<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <v-card
          class="elevation-10 mb-3"
          width="800px"
          height="300px"
          color="#9ACD32"
        >
          <div class="d-flex flex-no-wrap justify-space-between">
            <div>
              <v-card-title>
                <p class="text-h5">
                  <b> {{ game.nameEnglish }} </b>
                </p>
                <p class="font-weight-regular">
                  Bgg rating: {{ game.bggRating }}
                </p>
              </v-card-title>

              <v-card-subtitle>{{ game.description }}</v-card-subtitle>
              <v-card-text>
                <v-row>
                  <v-col cols="4">
                    <p class="font-weight-regular">
                      <b> {{ game.numberPlayers }} </b>
                    </p>
                    <p class="font-weight-light">Community</p>
                  </v-col>
                  <v-col cols="4">
                    <p class="font-weight-regular">
                      <b> {{ game.partyTime }} </b>
                    </p>
                    <p class="font-weight-light">Playing time</p>
                  </v-col>
                  <v-col cols="4">
                    <p class="font-weight-regular">
                      <b> Age: {{ game.age }} </b>
                    </p>
                    <p class="font-weight-light">Recommended age</p>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12">
                    <p class="font-weight-regular">
                      <b>Designer:</b> {{ game.designer }}
                    </p>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12">
                    <p class="font-weight-regular">
                      <b>Artist:</b> {{ game.author }}
                    </p>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12">
                    <p class="font-weight-regular">
                      <b>Publisher:</b> {{ game.publishingHouse }}
                    </p>
                  </v-col>
                </v-row>
              </v-card-text>

              <v-card-actions> </v-card-actions>
            </div>

            <v-avatar class="ma-3" size="200" rounded="0">
              <v-img :src="`data:image/png;base64,${game.photoImage}`"></v-img>
            </v-avatar>
          </div>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "BoardGame",

  props: ["id"],

  data() {
    return {};
  },

  computed: {
    game() {
      return this.$store.getters.gameById(this.id);
    },
  },

  methods: {},
};
</script>
