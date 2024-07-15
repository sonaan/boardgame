<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <app-alert
          v-if="error"
          :text="error_text"
          @dismissed="onDismissed"
        ></app-alert>
        <v-dialog v-model="dialog" width="auto">
          <v-card>
            <v-card-text> Заказ создан </v-card-text>
            <v-card-actions>
              <v-btn
                color="primary"
                block
                :to="'/exchange/'"
                @click="dialog = false"
                >Закрыть</v-btn
              >
            </v-card-actions>
          </v-card>
        </v-dialog>
        <p class="text-h5">
          <b> Оформление обмена</b>
        </p>
        <v-col cols="12" lg="4">
          <v-text-field
            label="Игра"
            v-model="order.game1"
            readonly
            variant="outlined"
          ></v-text-field>
        </v-col>
        <v-col cols="4" lg="2">
          <v-text-field
            label="Город"
            v-model="order.exchangerCity"
            readonly
            variant="outlined"
          ></v-text-field>
        </v-col>
        <v-col cols="8" lg="4">
          <v-text-field
            label="Адрес"
            v-model="order.address"
            readonly
            variant="outlined"
          ></v-text-field>
        </v-col>
        <v-col cols="12" lg="4">
          <v-textarea
            counter
            label="Описание"
            v-model="order.description1"
            variant="outlined"
            readonly
          ></v-textarea>
        </v-col>
        <v-col cols="12" lg="4">
          <v-select
            v-model="gamesExchange"
            :items="listselectboargames"
            item-title="game"
            item-value="gameid"
            label="Игры для обмена"
            multiple
            hint="Выберите игру для обмена"
            persistent-hint
            variant="outlined"
          ></v-select>
        </v-col>
        <v-col cols="12" lg="4">
          <v-textarea
            counter
            label="Описание"
            v-model="description2"
            variant="outlined"
          ></v-textarea>
        </v-col>
      </v-col>
      <v-col cols="12" lg="4" class="d-flex justify-end">
        <v-btn variant="outlined" @click="createOrder()">
          Оформить обмен
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  name: "ExchangeOrder",

  props: ["id"],

  data() {
    return {
      url: "/exchangeorder/update",
      method: "patch",
      data: JSON.stringify({}),
      error: false,
      dialog: false,
      gamesExchange: [],
      description2: "",
      error_text: "",
      photolink: "",
    };
  },

  computed: {
    order() {
      return this.$store.getters.exchangeOrderById(this.id);
    },
    user() {
      return this.$store.getters.user;
    },
    listselectboargames() {
      return this.$store.getters.listExchangeGameById(this.id);
    },
  },

  watch: {
    gamesExchange(event) {
      if (event != null) {
        this.photolink = this.$store.getters.photoLinkById(event[0]);
      }
    },
  },

  methods: {
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

    onDismissed() {
      console.log("Dismissed Alert");
      this.error = false;
    },

    photoLinkById(id) {
      return this.$store.getters.photoLinkById(id);
    },

    createOrder() {
      if (this.gamesExchange.length == 0) {
        this.error_text =
          "You should select one game for exchange from the list";
        this.error = true;
      } else if (this.gamesExchange.length > 1) {
        this.error_text =
          "You should select only one game for exchange from the list";
        this.error = true;
      } else if (this.description2 == "") {
        this.error_text =
          "You should short write state of your game for exchange";
        this.error = true;
      } else {
        this.error = false;
        this.data = JSON.stringify({
          id: this.id,
          userid2: this.user.id,
          gameid2: this.gamesExchange[0],
          description2: this.description2,
          photoLink2: this.photolink,
          orderStateId: 1,
        });
        this.getDataFromApi().then(() => {
          this.dialog = true;
        });
      }
    },
  },
};
</script>
