<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <DialogCreate
          v-if="admin"
          ref="dialogCreate"
          :mode="tab"
          class="float-md-end"
          @click="openCreate()"
          @close="refreshDate()"
        />
        <v-card
          class="elevation-10 mb-3"
          v-for="game in listboardgames"
          :key="game.id"
          width="800px"
          color="#9ACD32"
        >
          <div class="d-flex flex-no-wrap justify-space-between">
            <div>
              <v-card-title class="text-h6">
                {{ game.nameEnglish }}
              </v-card-title>

              <v-card-subtitle>{{ game.description }}</v-card-subtitle>

              <v-card-actions>
                <v-btn
                  class="ml-2"
                  variant="outlined"
                  size="small"
                  :to="'/game/' + game.id"
                >
                  Открыть игру
                </v-btn>
              </v-card-actions>
            </div>

            <v-avatar class="ma-3" size="125" rounded="0">
              <v-img :src="`data:image/png;base64,${game.photoImage}`"></v-img>
            </v-avatar>
          </div>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import DialogCreate from "@/components/dialogs/create/indexCreate.vue";

export default {
  name: "BoardGames",

  components: {
    DialogCreate,
  },

  data() {
    return {
      url: "/boardgame/allrows",
      method: "get",
      data: JSON.stringify({}),
    };
  },

  computed: {
    listboardgames() {
      return this.$store.getters.listboardgames;
    },
    admin() {
      return this.$store.getters.flag_admin;
    },
  },

  mounted() {
    this.getDataFromApi().then((data) => {
      this.setData(data);
    });
  },

  methods: {
    openCreate() {
      this.$refs.dialogCreate.dialog = true;
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
