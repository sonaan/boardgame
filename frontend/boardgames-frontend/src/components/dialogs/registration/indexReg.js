import axios from "axios";

export default {
  data() {
    return {
      url: "/user/allrows",
      method: "get",
      data: JSON.stringify({}),
      dialog: false,
      login: "",
      email: "",
      password: "",
      sex: "",
      error: false,
    };
  },

  computed: {
    error() {
      return this.$store.getters.error;
    },
  },

  methods: {
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

    onSignup() {
      this.method = "get";
      this.url = "/user/find/" + this.email;
      this.data = JSON.stringify({});
      this.getDataFromApi().then((data) => {
        if (data.data != -1) {
          this.error = true;
          return;
        } else {
          this.method = "post";
          this.url = "/user/new";
          this.data = JSON.stringify({
            login: this.login,
            sex: this.sex,
            email: this.email,
            password: this.password,
          });
          this.getDataFromApi().then(() => {
            this.email = null;
            this.login = null;
            this.password = null;
            this.dialog = false;
          });
        }
      });
    },

    close() {
      this.error = false;
      this.email = null;
      this.login = null;
      this.password = null;
      this.dialog = false;
    },

    onDismissed() {
      console.log("Dismissed Alert");
      this.error = false;
    },
  },
};
