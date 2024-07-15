import axios from "axios";
import SearchDropdown from "search-dropdown-vue";

export default {
  components: { SearchDropdown },
  props: {
    mode: { type: String, default: "" },
  },

  data() {
    return {
      url: "",
      url2: "",
      method: "get",
      data: JSON.stringify({}),
      dialog: false,
      selected_gameid: null,
      photoid: "",
    };
  },

  computed: {
    boardgames() {
      return this.$store.getters.listselectboargames;
    },
    user() {
      return this.$store.getters.user;
    },
  },

  watch: {
    selected_gameid(event) {
      if (event != null) {
        this.photoid = this.$store.getters.photoidById(event);
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

    game(gameid) {
      return this.$store.getters.gameById(gameid);
    },

    add() {
      this.method = "get";
      this.data = JSON.stringify({});
      switch (this.mode) {
        case "1":
          this.url =
            "/collection/gameexist/" +
            this.user.id +
            "/" +
            this.selected_gameid;
          this.url2 = "/collection/new/";
          break;
        case "2":
          this.url =
            "/exchange/gameexist/" + this.user.id + "/" + this.selected_gameid;
          this.url2 = "/exchange/new/";
          break;
        case "3":
          this.url =
            "/wantbuy/gameexist/" + this.user.id + "/" + this.selected_gameid;
          this.url2 = "/wantbuy/new/";
          break;
        case "4":
          this.url =
            "/wantplay/gameexist/" + this.user.id + "/" + this.selected_gameid;
          this.url2 = "/wantplay/new/";
          break;
        case "5":
          this.url =
            "/playedgame/gameexist/" +
            this.user.id +
            "/" +
            this.selected_gameid;
          this.url2 = "/playedgame/new/";
          break;
      }
      this.getDataFromApi().then((data) => {
        if (data.data == "") {
          this.method = "post";
          this.data = JSON.stringify({
            userid: this.user.id,
            gameid: this.selected_gameid,
            photoid: this.photoid,
          });
          this.url = this.url2;
          this.getDataFromApi().then(() => {
            this.selected_gameid = null;
            this.$emit("close");
          });
        } else {
          this.dialog = false;
        }
      });
    },

    close() {
      this.dialog = false;
    },
  },
};
