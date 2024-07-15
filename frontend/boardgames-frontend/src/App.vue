<template>
  <div id="app">
    <v-app id="inspire">
      <v-app-bar dark height="230" image>
        <template v-slot:image>
          <v-img
            src="./img/boardgame6.png"
            min-height="100"
            contain
            gradient="to top right, rgba(138,43,226,.8), rgba(127,255,0,.8)"
          ></v-img>
        </template>
        <v-spacer></v-spacer>
        <DialogRegistration
          v-if="!log_in"
          ref="dialogReg"
          @click="openRegistration()"
        />
        <DialogLogin v-if="!log_in" ref="dialogLogin" @click="openLogin()" />
        <v-btn v-if="log_in" @click="logout()" :to="'/'"
          ><v-icon>mdi-logout</v-icon></v-btn
        >
      </v-app-bar>

      <v-navigation-drawer clipped="clipped-left" width="350" image>
        <template v-slot:image>
          <v-img
            src="./img/white.png"
            gradient="to bottom left, rgba(138,43,226,.8), rgba(127,255,0,.8)"
            min-height="1000"
            contain
          ></v-img>
        </template>
        <v-list v-model:opened="open">
          <v-list-group value="Catalog">
            <template v-slot:activator="{ props }">
              <v-list-item
                v-bind="props"
                prepend-icon="mdi-file-cabinet"
                title="Каталог"
              ></v-list-item>
            </template>
            <v-list-item
              v-for="([title, icon, go], i) in catalogs_game"
              :key="i"
              :title="title"
              :prepend-icon="icon"
              :value="title"
              :to="go"
            ></v-list-item>
          </v-list-group>
          <v-list-group value="Users" v-if="log_in">
            <template v-slot:activator="{ props }">
              <v-list-item
                v-bind="props"
                prepend-icon="mdi-account-circle"
                title="Профиль"
              ></v-list-item>
            </template>
            <v-list-item
              v-for="([title, icon, go], i) in users_profile"
              :key="i"
              :title="title"
              :prepend-icon="icon"
              :value="title"
              :to="go"
            ></v-list-item>
          </v-list-group>
          <v-list-group value="Market" v-if="log_in">
            <template v-slot:activator="{ props }">
              <v-list-item
                v-bind="props"
                prepend-icon="mdi-sitemap"
                title="Маркет"
              ></v-list-item>
            </template>
            <v-list-item
              v-for="([title, icon, go], i) in markets"
              :key="i"
              :title="title"
              :prepend-icon="icon"
              :value="title"
              :to="go"
            ></v-list-item>
          </v-list-group>
        </v-list>
      </v-navigation-drawer>

      <v-divider class="my-2"></v-divider>

      <v-main class="grey lighten-3">
        <router-view />
      </v-main>
    </v-app>
  </div>
</template>

<script>
import DialogRegistration from "@/components/dialogs/registration/indexReg.vue";
import DialogLogin from "@/components/dialogs/login/indexLogin.vue";
import { mapActions } from "vuex";
import axios from "axios";

export default {
  name: "App",

  components: {
    DialogRegistration,
    DialogLogin,
  },

  data: () => ({
    open: ["Users", "Market"],
    catalogs_game: [["Игры", "mdi-format-align-justify", "/"]],
    users_profile: [
      ["Игры", "mdi-gamepad-variant", "/usergames/"],
      ["Друзья", "mdi-account-multiple", "/friend/"],
      ["Сообщения", "mdi-email", "/message/"],
      ["Маркет", "mdi-atom", "/market/"],
      ["Настройки", "mdi-account-settings"],
    ],
    markets: [
      ["Продать/Обменять игру", "mdi-basket-unfill", "/sell/"],
      ["Купить игру", "mdi-basket-fill", "/buy/"],
      ["Обменять игру", "mdi-autorenew", "/exchange/"],
    ],
    url: "/boardgame/allrows",
    method: "get",
    data: JSON.stringify({}),
  }),

  mounted() {
    this.getDataFromApi().then((data) => {
      this.setData(data);
    });
  },

  computed: {
    log_in() {
      return this.$store.getters.flag_login;
    },
  },

  methods: {
    ...mapActions(["setUser", "setFlagLogin", "setFlagAdmin"]),

    openRegistration() {
      this.$refs.dialogReg.dialog = true;
    },

    openLogin() {
      this.$refs.dialogLogin.dialog = true;
    },

    logout() {
      this.setFlagLogin(false);
      this.setFlagAdmin(false);
      this.setUser({});
    },

    getDataFromApi() {
      var config = {
        method: this.method,
        url: this.url,
        headers: {
          "Content-Type": "application/json",
        },
        data: this.data,
      };

      return axios(config);
    },

    setData(data) {
      if (data.data.length > 0) {
        this.$store.dispatch("setListBoardgames", data.data);
      }
    },
  },
};
</script>
