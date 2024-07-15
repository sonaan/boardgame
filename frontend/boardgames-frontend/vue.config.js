const { defineConfig } = require("@vue/cli-service");

module.exports = defineConfig({
  transpileDependencies: true,
  publicPath: "./",
  outputDir: "dist",
  //assetsDir: "static",

  pluginOptions: {
    vuetify: {
      // https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
    },
  },

  // outputDir: "../src/main/resources/static", // Build Directory

  devServer: {
    historyApiFallback: {
      index: "/dist/index.html",
    },
    proxy: {
      "^/boardgame/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/user/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/collection/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/wantbuy/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/wantplay/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/playedgame/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/exchange/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/purchaseorder/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/exchangeorder/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/listgameexchange/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/friend/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/message/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
      "^/photo/*": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        logLevel: "debug",
      },
    },
  },
});
