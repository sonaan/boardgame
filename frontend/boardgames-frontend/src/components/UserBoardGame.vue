<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <v-card>
          <DialogSearch
            ref="dialogSearch"
            :mode="tab"
            class="float-md-end"
            @click="openSearch()"
            @close="refreshDate()"
          />
          <v-tabs
            v-model="tab"
            color="deep-purple-accent-4"
            align-tabs="center"
          >
            <v-tab value="1">Коллекция</v-tab>
            <v-tab value="2">Хочу поменять</v-tab>
            <v-tab value="3">Хочу купить</v-tab>
            <v-tab value="4">Хочу сыграть</v-tab>
            <v-tab value="5">Играл</v-tab>
          </v-tabs>
          <v-window v-model="tab">
            <v-window-item value="1" key="1">
              <v-container fluid>
                <v-row>
                  <v-col
                    v-for="item in collection"
                    :key="item.id"
                    cols="12"
                    md="2"
                  >
                    <v-row>
                      <v-col cols="8">
                        <v-img
                          :src="getPhotoImageById(item.gameid)"
                          aspect-ratio="1"
                          max-height="200"
                        ></v-img>
                      </v-col>
                      <v-col cols="4">
                        <v-btn
                          class="float-md-start"
                          size="x-small"
                          icon="mdi-alpha-x-box-outline"
                          @click="deleteGame(item.id)"
                        ></v-btn>
                      </v-col>
                    </v-row>
                  </v-col>
                </v-row>
              </v-container>
            </v-window-item>
            <v-window-item value="2" key="2">
              <v-container fluid>
                <v-row>
                  <v-col
                    v-for="item in wantexchange"
                    :key="item.id"
                    cols="12"
                    md="2"
                  >
                    <v-row>
                      <v-col cols="8">
                        <v-img
                          :src="getPhotoImageById(item.gameid)"
                          aspect-ratio="1"
                          max-height="200"
                        ></v-img>
                      </v-col>
                      <v-col cols="4">
                        <v-btn
                          class="float-md-start"
                          size="x-small"
                          icon="mdi-alpha-x-box-outline"
                          @click="deleteGame(item.id)"
                        ></v-btn>
                      </v-col>
                    </v-row>
                  </v-col>
                </v-row>
              </v-container>
            </v-window-item>
            <v-window-item value="3" key="3">
              <v-container fluid>
                <v-row>
                  <v-col
                    v-for="item in wantbuy"
                    :key="item.id"
                    cols="12"
                    md="2"
                  >
                    <v-row>
                      <v-col cols="8">
                        <v-img
                          :src="getPhotoImageById(item.gameid)"
                          aspect-ratio="1"
                          max-height="200"
                        ></v-img>
                      </v-col>
                      <v-col cols="4">
                        <v-btn
                          class="float-md-start"
                          size="x-small"
                          icon="mdi-alpha-x-box-outline"
                          @click="deleteGame(item.id)"
                        ></v-btn>
                      </v-col>
                    </v-row>
                  </v-col>
                </v-row>
              </v-container>
            </v-window-item>
            <v-window-item value="4" key="4">
              <v-container fluid>
                <v-row>
                  <v-col
                    v-for="item in wantplay"
                    :key="item.id"
                    cols="12"
                    md="2"
                  >
                    <v-row>
                      <v-col cols="8">
                        <v-img
                          :src="getPhotoImageById(item.gameid)"
                          aspect-ratio="1"
                          max-height="200"
                        ></v-img>
                      </v-col>
                      <v-col cols="4">
                        <v-btn
                          class="float-md-start"
                          size="x-small"
                          icon="mdi-alpha-x-box-outline"
                          @click="deleteGame(item.id)"
                        ></v-btn>
                      </v-col>
                    </v-row>
                  </v-col>
                </v-row>
              </v-container>
            </v-window-item>
            <v-window-item value="5" key="5">
              <v-container fluid>
                <v-row>
                  <v-col
                    v-for="item in playedgame"
                    :key="item.id"
                    cols="12"
                    md="2"
                  >
                    <v-row>
                      <v-col cols="8">
                        <v-img
                          :src="getPhotoImageById(item.gameid)"
                          aspect-ratio="1"
                          max-height="200"
                        ></v-img>
                      </v-col>
                      <v-col cols="4">
                        <v-btn
                          class="float-md-start"
                          size="x-small"
                          icon="mdi-alpha-x-box-outline"
                          @click="deleteGame(item.id)"
                        ></v-btn>
                      </v-col>
                    </v-row>
                  </v-col>
                </v-row>
              </v-container>
            </v-window-item>
          </v-window>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import DialogSearch from "@/components/dialogs/search/indexSearch.vue";
import { mapActions } from "vuex";
import axios from "axios";

export default {
  name: "UserBoardGame",

  components: {
    DialogSearch,
  },

  data() {
    return {
      tab: null,
      url: "/collection/",
      method: "delete",
      data: JSON.stringify({}),
    };
  },

  computed: {
    collection() {
      return this.$store.getters.collection;
    },
    wantbuy() {
      return this.$store.getters.wantbuy;
    },
    wantplay() {
      return this.$store.getters.wantplay;
    },
    playedgame() {
      return this.$store.getters.playedgame;
    },
    wantexchange() {
      return this.$store.getters.wantexchange;
    },
    user() {
      return this.$store.getters.user;
    },
  },

  methods: {
    ...mapActions([
      "loadCollection",
      "loadWantBuy",
      "loadWantPlay",
      "loadPlayedGame",
      "loadWantExchange",
      "photoImageById",
    ]),
    getPhotoImageById(id) {
      return this.$store.getters.photoImageById(id);
    },
    openSearch() {
      this.$refs.dialogSearch.dialog = true;
    },
    refreshDate() {
      this.$refs.dialogSearch.dialog = false;
      switch (this.tab) {
        case "1":
          this.loadCollection(this.user.id);
          break;
        case "2":
          this.loadWantExchange(this.user.id);
          break;
        case "3":
          this.loadWantBuy(this.user.id);
          break;
        case "4":
          this.loadWantPlay(this.user.id);
          break;
        case "5":
          this.loadPlayedGame(this.user.id);
          break;
      }
    },
    deleteGame(id) {
      switch (this.tab) {
        case "1":
          this.url = "/collection/" + id;
          break;
        case "2":
          this.url = "/exchange/" + id;
          break;
        case "3":
          this.url = "/wantbuy/" + id;
          break;
        case "4":
          this.url = "/wantplay/" + id;
          break;
        case "5":
          this.url = "/playedgame/" + id;
          break;
      }
      this.getDataFromApi().then((data) => {
        console.log(data);
        this.refreshDate();
      });
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
  },
};
</script>
