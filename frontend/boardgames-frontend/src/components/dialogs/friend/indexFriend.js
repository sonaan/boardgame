import axios from "axios";
import SearchDropdown from "search-dropdown-vue";

export default {
  components: { SearchDropdown },

  data() {
    return {
      url: "/friend/new/",
      method: "post",
      data: JSON.stringify({}),
      dialog: false,
      selected_userid: null,
    };
  },

  computed: {
    listusers() {
      return this.$store.getters.listusernotfriend;
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

    add() {
      this.data = JSON.stringify({
        userid1: this.user.id,
        userid2: this.selected_userid,
      });
      this.getDataFromApi().then(() => {
        this.$emit("close");
      });
    },

    close() {
      this.dialog = false;
    },
  },
};
