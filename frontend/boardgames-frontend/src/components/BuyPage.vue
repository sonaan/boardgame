<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <DialogMessage
          ref="dialogMessage"
          :useridsend="this.user.id"
          :useridreceive="useridreceive"
          :userloginsend="userloginreceive"
          @close="closeMessage()"
        />
      </v-col>
      <v-col cols="12">
        <v-card
          class="elevation-10 mb-3"
          v-for="item in listpurchaseorder"
          :key="item.id"
          width="800px"
          min-height="300px"
          color="#9ACD32"
        >
          <div class="d-flex flex-no-wrap justify-space-between">
            <div>
              <v-card-title>
                <p class="text-h5">
                  <b> {{ item.game }} </b>
                </p>
              </v-card-title>

              <v-card-text>
                <v-row>
                  <v-col cols="10">
                    <p class="font-weight-regular">
                      <b>Описание:</b> {{ item.description }}
                    </p>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="3">
                    <p class="font-weight-regular">
                      <b> Цена: </b> {{ item.price }}
                    </p>
                  </v-col>
                  <v-col cols="4">
                    <p class="font-weight-regular">
                      <b> Город: </b> {{ item.sellerCity }}
                    </p>
                  </v-col>
                  <v-col cols="5">
                    <p class="font-weight-regular">
                      <b> Способ доставки: </b> {{ item.shippingMethod }}
                    </p>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12">
                    <v-row>
                      <v-col cols="7">
                        <p class="font-weight-regular">
                          <b>Продавец:</b> {{ item.seller }}
                        </p>
                      </v-col>
                      <v-col cols="5">
                        <v-btn
                          color="#9ACD32"
                          icon="mdi-email"
                          size="x-small"
                          class="float-md-start"
                          :disabled="this.user.id == item.sellerid"
                          @click="openMessage(item)"
                        ></v-btn>
                      </v-col>
                    </v-row>
                  </v-col>
                  <v-col cols="12">
                    <p class="font-weight-regular">
                      <b>Адрес:</b> {{ item.address }}
                    </p>
                  </v-col>
                </v-row>
              </v-card-text>

              <v-card-actions>
                <v-btn
                  class="ml-2"
                  variant="outlined"
                  size="small"
                  :disabled="this.user.id == item.sellerid"
                  :to="'/purchaseorder/' + item.id"
                >
                  Купить
                </v-btn>
              </v-card-actions>
            </div>

            <v-avatar class="ma-3" size="200" rounded="0">
              <v-img :src="getPhotoImageById(item.gameid)"></v-img>
            </v-avatar>
          </div>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import DialogMessage from "@/components/dialogs/message/indexMessage.vue";
import { mapActions } from "vuex";

export default {
  name: "BuyPage",

  components: {
    DialogMessage,
  },

  data() {
    return {
      url: "/purchaseorder/allrows",
      method: "get",
      data: JSON.stringify({}),
      dialogmessage: false,
      useridreceive: "",
      userloginreceive: "",
    };
  },

  computed: {
    listpurchaseorder() {
      return this.$store.getters.activelistpurchaseorder;
    },
    user() {
      return this.$store.getters.user;
    },
  },

  mounted() {
    this.getDataFromApi().then((data) => {
      this.setData(data);
    });
  },

  methods: {
    ...mapActions(["loadMessageOutbox", "photoImageById"]),

    getPhotoImageById(id) {
      return this.$store.getters.photoImageById(id);
    },

    getDataFromApi() {
      var config = {
        method: this.method,
        url: this.url,
        headers: {
          Authorization: `Bearer ${this.$store.getters.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: this.data,
      };

      return axios(config);
    },

    setData(data) {
      if (data.data.length > 0) {
        this.$store.dispatch("setListPurchaseOrder", data.data);
      }
    },

    openMessage(user) {
      this.useridreceive = user.sellerid;
      this.userloginreceive = user.seller;
      this.$refs.dialogMessage.dialogmessage = true;
    },
    closeMessage() {
      this.$refs.dialogMessage.dialogmessage = false;
      this.loadMessageOutbox(this.user.id);
    },
  },
};
</script>
