<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <app-alert
          v-if="error"
          text="Payment method wasn't filled"
          @dismissed="onDismissed"
        ></app-alert>
        <v-dialog v-model="dialog" width="auto">
          <v-card>
            <v-card-text> Заказ создан </v-card-text>
            <v-card-actions>
              <v-btn color="primary" block :to="'/buy/'" @click="dialog = false"
                >Закрыть</v-btn
              >
            </v-card-actions>
          </v-card>
        </v-dialog>
        <p class="text-h5">
          <b> Оформление покупки</b>
        </p>
        <v-col cols="12" lg="4">
          <v-text-field
            label="Игра"
            v-model="order.game"
            readonly
            variant="outlined"
          ></v-text-field>
        </v-col>
        <v-col cols="12" lg="1">
          <v-text-field
            label="Цена"
            v-model="order.price"
            variant="outlined"
            readonly
          ></v-text-field>
        </v-col>
        <v-col cols="12" lg="4">
          <v-text-field
            label="Город"
            v-model="order.sellerCity"
            readonly
            variant="outlined"
          ></v-text-field>
        </v-col>
        <v-col cols="12" lg="4">
          <v-text-field
            label="Адрес"
            v-model="order.address"
            readonly
            variant="outlined"
          ></v-text-field>
        </v-col>
        <v-col cols="12" lg="4">
          <v-text-field
            label="Способ доставки"
            v-model="order.shippingMethod"
            readonly
            variant="outlined"
          ></v-text-field>
        </v-col>
        <v-col cols="12" lg="4">
          <v-textarea
            counter
            label="Описание"
            v-model="order.description"
            variant="outlined"
            readonly
          ></v-textarea>
        </v-col>
        <v-col cols="12" lg="4">
          <v-select
            :items="payment_method"
            v-model="paymentΜethod"
            label="Способ оплаты"
            variant="outlined"
          ></v-select>
        </v-col>
      </v-col>
      <v-col cols="12" lg="4" class="d-flex justify-end">
        <v-btn variant="outlined" @click="createOrder()">
          Оформить покупку
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  name: "PurchaseOrder",

  props: ["id"],

  data() {
    return {
      url: "/purchaseorder/update",
      method: "patch",
      data: JSON.stringify({}),
      payment_method: ["Cash", "Card"],
      paymentΜethod: "",
      error: false,
      dialog: false,
    };
  },

  computed: {
    order() {
      return this.$store.getters.purchaseOrderById(this.id);
    },
    user() {
      return this.$store.getters.user;
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

    createOrder() {
      if (this.paymentΜethod == "") {
        this.error = true;
      } else {
        this.error = false;
        this.data = JSON.stringify({
          id: this.id,
          buyerid: this.user.id,
          orderStateId: 1,
          paymentMethodId: this.paymentΜethod == "Cash" ? 1 : 2,
          paymentStateId: 1,
        });
        this.getDataFromApi().then(() => {
          this.dialog = true;
        });
      }
    },
  },
};
</script>
