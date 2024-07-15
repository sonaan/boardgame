<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <v-tabs v-model="tab" color="deep-purple-accent-4" align-tabs="center">
          <v-tab value="1">Мои продажи</v-tab>
          <v-tab value="2">Мои покупки</v-tab>
          <v-tab value="3">Игры на обмен</v-tab>
          <v-tab value="4">Заказы на обмен</v-tab>
        </v-tabs>
        <v-window v-model="tab">
          <v-window-item value="1" key="1">
            <v-container fluid>
              <v-row>
                <v-card
                  class="elevation-10 ma-3"
                  v-for="item in userlistsell"
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
                              <b> Способ доставки: </b>
                              {{ item.shippingMethod }}
                            </p>
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
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Статус заказа:</b> {{ item.orderState }}
                            </p>
                          </v-col>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Способ оплаты:</b> {{ item.paymentMethod }}
                            </p>
                          </v-col>
                        </v-row>
                        <v-row>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Покупатель:</b> {{ item.buyer }}
                            </p>
                          </v-col>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Статус оплаты:</b> {{ item.paymentState }}
                            </p>
                          </v-col>
                        </v-row>
                      </v-card-text>
                      <v-card-actions class="align-content-end">
                        <v-row>
                          <v-col cols="6">
                            <v-btn
                              class="ml-2"
                              variant="outlined"
                              size="small"
                              :disabled="
                                item.paymentState == 'not paid' ||
                                item.buyerid == null
                              "
                            >
                              Закрыть
                            </v-btn>
                          </v-col>
                          <v-col cols="6">
                            <v-btn
                              class="ml-2"
                              variant="outlined"
                              size="small"
                              :disabled="
                                item.paymentState == 'paid' ||
                                item.paymentState == null
                              "
                            >
                              Заказ оплачен
                            </v-btn>
                          </v-col>
                        </v-row>
                      </v-card-actions>
                    </div>

                    <v-avatar class="ma-3" size="200" rounded="0">
                      <v-img :src="getPhotoImageById(item.gameid)"></v-img>
                    </v-avatar>
                  </div>
                </v-card>
              </v-row>
            </v-container>
          </v-window-item>
          <v-window-item value="2" key="2">
            <v-container fluid>
              <v-row>
                <v-card
                  class="elevation-10 ma-3"
                  v-for="item in userlistpurchase"
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
                              <b> Способ доставки: </b>
                              {{ item.shippingMethod }}
                            </p>
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
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Статус заказа:</b> {{ item.orderState }}
                            </p>
                          </v-col>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Способ оплаты:</b> {{ item.paymentMethod }}
                            </p>
                          </v-col>
                        </v-row>
                        <v-row>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Продавец:</b> {{ item.seller }}
                            </p>
                          </v-col>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Статус оплаты:</b> {{ item.paymentState }}
                            </p>
                          </v-col>
                        </v-row>
                      </v-card-text>
                      <v-card-actions> </v-card-actions>
                    </div>

                    <v-avatar class="ma-3" size="200" rounded="0">
                      <v-img :src="getPhotoImageById(item.gameid)"></v-img>
                    </v-avatar>
                  </div>
                </v-card>
              </v-row>
            </v-container>
          </v-window-item>
          <v-window-item value="3" key="3">
            <v-container fluid>
              <v-row>
                <v-card
                  class="elevation-10 ma-3"
                  v-for="item in userlistexchange"
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
                          <v-col cols="10">
                            <p class="font-weight-regular">
                              <b>Описание:</b> {{ item.description1 }}
                            </p>
                          </v-col>
                        </v-row>
                        <v-row>
                          <v-col lg="6">
                            <p class="font-weight-regular">
                              <b> Город: </b> {{ item.exchangerCity }}
                            </p>
                          </v-col>
                          <v-col lg="6">
                            <p class="font-weight-regular">
                              <b>Адрес:</b> {{ item.address }}
                            </p>
                          </v-col>
                        </v-row>
                        <v-row v-if="item.user2 != null">
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Обмен с пользователем:</b> {{ item.user2 }}
                            </p>
                          </v-col>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Статус заказа:</b> {{ item.orderState }}
                            </p>
                          </v-col>
                        </v-row>
                        <v-row v-if="item.user2 != null">
                          <v-col cols="12">
                            <p class="font-weight-regular">
                              <b>Игра для обмена:</b>
                            </p>
                          </v-col>
                          <v-col cols="6">
                            <v-img
                              :src="getPhotoImageById(item.gameid2)"
                              :width="80"
                              aspect-ratio="16/9"
                              cover
                            ></v-img>
                          </v-col>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Описание:</b> {{ item.description2 }}
                            </p>
                          </v-col>
                        </v-row>
                        <v-row v-if="item.user2 == null">
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
                      <v-card-actions class="align-content-end">
                        <v-row v-if="item.photoLink2 != null">
                          <v-col cols="12">
                            <v-btn
                              class="ml-2"
                              variant="outlined"
                              size="small"
                              :disabled="
                                item.orderState == 'Closed' ||
                                item.user2 == null
                              "
                            >
                              Закрыть
                            </v-btn>
                          </v-col>
                        </v-row>
                      </v-card-actions>
                    </div>

                    <v-avatar class="ma-3" size="200" rounded="0">
                      <v-img :src="getPhotoImageById(item.gameid1)"></v-img>
                    </v-avatar>
                  </div>
                </v-card>
              </v-row>
            </v-container>
          </v-window-item>
          <v-window-item value="4" key="4">
            <v-container fluid>
              <v-row>
                <v-card
                  class="elevation-10 ma-3"
                  v-for="item in userlistexchangeorder"
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
                          <v-col cols="10">
                            <p class="font-weight-regular">
                              <b>Описание:</b> {{ item.description1 }}
                            </p>
                          </v-col>
                        </v-row>
                        <v-row>
                          <v-col lg="6">
                            <p class="font-weight-regular">
                              <b> Город: </b> {{ item.exchangerCity }}
                            </p>
                          </v-col>
                          <v-col lg="6">
                            <p class="font-weight-regular">
                              <b>Адрес:</b> {{ item.address }}
                            </p>
                          </v-col>
                        </v-row>
                        <v-row v-if="item.user2 != null">
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Обмен с пользователем:</b> {{ item.user1 }}
                            </p>
                          </v-col>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Статус заказа:</b> {{ item.orderState }}
                            </p>
                          </v-col>
                        </v-row>
                        <v-row>
                          <v-col cols="12">
                            <p class="font-weight-regular">
                              <b>Моя игра для обмена:</b>
                            </p>
                          </v-col>
                          <v-col cols="6">
                            <v-img
                              :src="getPhotoImageById(item.gameid2)"
                              :width="80"
                              aspect-ratio="16/9"
                              cover
                            ></v-img>
                          </v-col>
                          <v-col cols="6">
                            <p class="font-weight-regular">
                              <b>Описание:</b> {{ item.description2 }}
                            </p>
                          </v-col>
                        </v-row>
                      </v-card-text>
                    </div>

                    <v-avatar class="ma-3" size="200" rounded="0">
                      <v-img :src="getPhotoImageById(item.gameid1)"></v-img>
                    </v-avatar>
                  </div>
                </v-card>
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
  name: "MarketPage",

  data() {
    return {
      url: "/purchaseorder/update",
      method: "patch",
      data: JSON.stringify({}),
      tab: null,
    };
  },

  computed: {
    userlistsell() {
      return this.$store.getters.userlistsell;
    },
    userlistpurchase() {
      return this.$store.getters.userlistpurchase;
    },
    userlistexchange() {
      return this.$store.getters.userlistexchange;
    },
    userlistexchangeorder() {
      return this.$store.getters.userlistexchangeorder;
    },
  },

  methods: {
    ...mapActions(["photoImageById"]),

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

    getListGame(id) {
      return this.$store.getters.listGameById(id);
    },

    getPhotoImageById(id) {
      return this.$store.getters.photoImageById(id);
    },
  },
};
</script>
