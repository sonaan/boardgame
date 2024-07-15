<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <app-alert
          v-if="error"
          text="Not all required fields were filled"
          @dismissed="onDismissed"
        ></app-alert>
        <v-dialog v-model="dialog" width="auto">
          <v-card>
            <v-card-text> Объявление было успешно создано </v-card-text>
            <v-card-actions>
              <v-btn color="primary" block @click="dialog = false"
                >Закрыть</v-btn
              >
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-tabs v-model="tab" color="deep-purple-accent-4" align-tabs="center">
          <v-tab value="1">Добавление объявления продажи</v-tab>
          <v-tab value="2">Добавление объявления обмена</v-tab>
        </v-tabs>
        <v-window v-model="tab">
          <v-window-item value="1" key="1">
            <v-container fluid>
              <v-row>
                <v-col cols="12">
                  <v-col cols="12" lg="3">
                    <v-select
                      v-model="selected_sell_gameid"
                      label="Игра"
                      :items="listselectboargames"
                      item-title="name"
                      item-value="id"
                      variant="outlined"
                    >
                    </v-select>
                  </v-col>
                  <v-col cols="12" lg="1">
                    <v-text-field
                      label="Цена"
                      v-model="price"
                      variant="outlined"
                      placeholder="5000"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" lg="2">
                    <v-select
                      :items="city"
                      v-model="selected_sell_city"
                      label="Город"
                      density="comfortable"
                      variant="outlined"
                    ></v-select>
                  </v-col>
                  <v-col cols="12" lg="4">
                    <v-text-field
                      label="Адрес"
                      v-model="sell_address"
                      variant="outlined"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" lg="2">
                    <v-select
                      :items="shipping_method"
                      v-model="ship_method"
                      label="Способ доставки"
                      density="comfortable"
                      variant="outlined"
                    ></v-select>
                  </v-col>
                  <v-col cols="12" lg="4">
                    <v-textarea
                      counter
                      label="Описание"
                      v-model="sell_description"
                      variant="outlined"
                    ></v-textarea>
                  </v-col>
                  <v-col cols="12" lg="4" class="d-flex justify-end">
                    <v-btn variant="outlined" @click="createAdSell()">
                      Создать объявление продажи
                    </v-btn>
                  </v-col>
                </v-col>
              </v-row>
            </v-container>
          </v-window-item>
          <v-window-item value="2" key="2">
            <v-container fluid>
              <v-row>
                <v-col cols="12">
                  <v-col cols="12" lg="2">
                    <v-select
                      v-model="selected_exch_gameid"
                      label="Игра"
                      :items="listselectboargames"
                      item-title="name"
                      item-value="id"
                      variant="outlined"
                    >
                    </v-select>
                  </v-col>
                  <v-col cols="12" lg="2">
                    <v-select
                      :items="city"
                      v-model="selected_exch_city"
                      label="Город"
                      density="comfortable"
                      variant="outlined"
                    ></v-select>
                  </v-col>
                  <v-col cols="12" lg="4">
                    <v-text-field
                      label="Адрес"
                      v-model="exch_address"
                      variant="outlined"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" lg="4">
                    <v-textarea
                      counter
                      label="Описание"
                      v-model="exch_description"
                      variant="outlined"
                    ></v-textarea>
                  </v-col>
                  <v-col cols="12" lg="4">
                    <v-select
                      v-model="gamesExchange"
                      :items="listselectboargames"
                      item-title="name"
                      item-value="id"
                      label="Игры для обмена"
                      multiple
                      hint="Выберите игры для обмена"
                      persistent-hint
                      variant="outlined"
                    ></v-select>
                  </v-col>
                  <v-col cols="12" lg="4" class="d-flex justify-end">
                    <v-btn variant="outlined" @click="createAdExchange()">
                      Создать объявление обмена
                    </v-btn>
                  </v-col>
                </v-col>
              </v-row>
            </v-container>
          </v-window-item>
        </v-window>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import { mapActions } from "vuex";

export default {
  name: "SellPage",

  data() {
    return {
      url: "",
      method: "",
      data: JSON.stringify({}),
      tab: null,
      city: ["Санкт-Петербург", "Москва"],
      shipping_method: [
        "Без доставки",
        "Почта",
        "Транспортная компания",
        "По договоренности",
      ],
      selected_sell_gameid: null,
      price: "",
      selected_sell_city: "",
      sell_address: "",
      ship_method: "",
      sell_description: "",
      sell_photo_link: "",
      selected_exch_gameid: null,
      selected_exch_city: "",
      exch_address: "",
      exch_description: "",
      exch_photo_link: "",
      error: false,
      dialog: false,
      selected_exch_game: null,
      gamesExchange: [],
    };
  },

  computed: {
    listselectboargames() {
      return this.$store.getters.listselectboargames;
    },
    user() {
      return this.$store.getters.user;
    },
  },

  watch: {
    selected_sell_gameid(event) {
      if (event != null) {
        this.sell_photo_link = this.$store.getters.photoLinkById(event);
      }
    },
    selected_exch_gameid(event) {
      if (event != null) {
        this.exch_photo_link = this.$store.getters.photoLinkById(event);
      }
    },
  },

  methods: {
    ...mapActions([
      "loadListGameExchange",
      "loadExchangeOrder",
      "photoImageById",
      "loadPurchaseOrder",
    ]),
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

    createAdSell() {
      if (
        this.selected_sell_gameid == null ||
        this.price == "" ||
        this.selected_sell_city == "" ||
        this.sell_address == "" ||
        this.ship_method == "" ||
        this.sell_description == ""
      ) {
        this.error = true;
      } else {
        this.error = false;
        this.method = "post";
        this.url = "/purchaseorder/new/";
        this.data = JSON.stringify({
          sellerid: this.user.id,
          gameid: this.selected_sell_gameid,
          sellerCity: this.selected_sell_city,
          address: this.sell_address,
          price: this.price,
          shippingMethod: this.ship_method,
          description: this.sell_description,
          photoLink: this.sell_photo_link,
        });
        this.getDataFromApi().then(() => {
          this.loadPurchaseOrder(this.$store.getters.user.id);
          this.dialog = true;
          this.selected_sell_gameid = null;
          this.selected_sell_city = null;
          this.sell_address = null;
          this.price = null;
          this.ship_method = null;
          this.sell_description = null;
          this.sell_photo_link = null;
        });
      }
    },

    createAdExchange() {
      if (
        this.selected_exch_gameid == null ||
        this.selected_exch_city == "" ||
        this.exch_address == "" ||
        this.exch_description == "" ||
        this.gamesExchange.length == 0
      ) {
        this.error = true;
      } else {
        this.error = false;
        this.method = "post";
        this.url = "/exchangeorder/new/";
        this.data = JSON.stringify({
          userid1: this.user.id,
          gameid1: this.selected_exch_gameid,
          exchangerCity: this.selected_exch_city,
          address: this.exch_address,
          description1: this.exch_description,
          photoLink1: this.exch_photo_link,
        });
        this.getDataFromApi().then((data) => {
          this.url = "/listgameexchange/new/";
          this.gamesExchange.forEach((element) => {
            this.data = JSON.stringify({
              exchangeid: data.data,
              gameid: element,
            });
            this.getDataFromApi().then(() => {
              console.log("listgameexchange created");
              this.loadExchangeOrder(this.$store.getters.user.id);
              this.loadListGameExchange(this.$store.getters.user.id);
              this.dialog = true;
              this.selected_exch_gameid = null;
              this.selected_exch_city = null;
              this.exch_address = null;
              this.exch_description = null;
              this.selected_exch_gameid = null;
              this.exch_photo_link = null;
              this.gamesExchange.length = 0;
            });
          });
        });
      }
    },
  },
};
</script>
