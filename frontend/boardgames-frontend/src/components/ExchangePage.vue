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
          v-for="item in listexchangeorder"
          :key="item.id"
          width="800px"
          min-height="300px"
          color="#9ACD32"
        >
          <div class="d-flex flex-no-wrap justify-space-between">
            <div>
              <v-card-title>
                <p class="text-h5">
                  <b> {{ item.game1 }} </b>
                </p>
              </v-card-title>

              <v-card-text>
                <v-row>
                  <v-col cols="12">
                    <p class="font-weight-regular">
                      <b>Описание:</b> {{ item.description1 }}
                    </p>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12">
                    <p class="font-weight-regular">
                      <b> Город: </b> {{ item.exchangerCity }}
                    </p>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12">
                    <v-row>
                      <v-col cols="7">
                        <p class="font-weight-regular">
                          <b>Вледелец игры:</b> {{ item.user1 }}
                        </p>
                      </v-col>
                      <v-col cols="5">
                        <v-btn
                          color="#9ACD32"
                          icon="mdi-email"
                          size="x-small"
                          class="float-md-start"
                          :disabled="this.user.id == item.userid1"
                          @click="openMessage(item)"
                        ></v-btn>
                      </v-col>
                    </v-row>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12">
                    <p class="font-weight-regular">
                      <b>Адрес:</b> {{ item.address }}
                    </p>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12">
                    <p class="font-weight-regular">
                      <b>Возможные игры для обмена:</b>
                    </p>
                  </v-col>
                  <v-container fluid>
                    <v-row>
                      <v-col
                        v-for="list_item in getListGame(item.id)"
                        :key="list_item.id"
                        cols="2"
                      >
                        <v-img
                          :src="`data:image/png;base64,${list_item.photoImage}`"
                          :width="80"
                          aspect-ratio="16/9"
                          cover
                        ></v-img>
                      </v-col>
                    </v-row>
                  </v-container>
                </v-row>
              </v-card-text>

              <v-card-actions>
                <v-btn
                  class="ml-2"
                  variant="outlined"
                  size="small"
                  :disabled="this.user.id == item.userid1"
                  :to="'/exchangeorder/' + item.id"
                >
                  Обменять
                </v-btn>
              </v-card-actions>
            </div>
            <v-avatar class="ma-3" size="200" rounded="0">
              <v-img :src="getPhotoImageById(item.gameid1)"></v-img>
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
  name: "ExchangePage",

  components: {
    DialogMessage,
  },

  data() {
    return {
      url: "/exchangeorder/allrows",
      method: "get",
      data: JSON.stringify({}),
      dialogmessage: false,
      useridreceive: "",
      userloginreceive: "",
    };
  },

  computed: {
    listexchangeorder() {
      return this.$store.getters.activelistexchangeorder;
    },
    user() {
      return this.$store.getters.user;
    },
  },

  mounted() {
    this.getDataFromApi().then((data) => {
      this.setData(data);
      this.url = "/listgameexchange/allrows";
      this.getDataFromApi().then((data) => {
        this.setListGameData(data);
      });
    });
  },

  methods: {
    ...mapActions(["loadMessageOutbox", "photoImageById"]),
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

    getPhotoImageById(id) {
      return this.$store.getters.photoImageById(id);
    },

    setData(data) {
      if (data.data.length > 0) {
        this.$store.dispatch("setListExchangeOrder", data.data);
      }
    },

    setListGameData(data) {
      if (data.data.length > 0) {
        this.$store.dispatch("setListGameExchange", data.data);
      }
    },

    getListGame(id) {
      return this.$store.getters.listGameById(id);
    },

    photoLinkById(id) {
      return this.$store.getters.photoLinkById(id);
    },

    openMessage(user) {
      this.useridreceive = user.userid1;
      this.userloginreceive = user.user1;
      this.$refs.dialogMessage.dialogmessage = true;
    },
    closeMessage() {
      this.$refs.dialogMessage.dialogmessage = false;
      this.loadMessageOutbox(this.user.id);
    },
  },
};
</script>
