import { createStore } from "vuex";
import axios from "axios";

export default createStore({
  state: {
    listboardgames: [],
    collection: [],
    wantbuy: [],
    wantplay: [],
    playedgame: [],
    wantexchange: [],
    token: null,
    user: {},
    flag_login: false,
    flag_admin: false,
    listselectboargames: [],
    listpurchaseorder: [],
    listexchangeorder: [],
    listgameexchange: [],
    listfriend: [],
    allusers: [],
    messageinbox: [],
    messageoutbox: [],
  },
  getters: {
    user(state) {
      return state.user;
    },
    listboardgames(state) {
      return state.listboardgames;
    },
    listselectboargames(state) {
      return state.listselectboargames;
    },
    listpurchaseorder(state) {
      return state.listpurchaseorder;
    },
    listfriendget(state) {
      var list = [];
      state.listfriend.forEach((element) => {
        if (element.userid1 != state.user.id) {
          var item = new Object();
          item.userid = element.userid1;
          item.login = element.login1;
          list.push(item);
        } else if (element.userid2 != state.user.id) {
          var item2 = new Object();
          item2.userid = element.userid2;
          item2.login = element.login2;
          list.push(item2);
        }
      });
      return list;
    },
    listmessageinbox(state) {
      return state.messageinbox;
    },
    listmessageoutbox(state) {
      return state.messageoutbox;
    },
    listusernotfriend(state) {
      var list = [];
      var flag = false;
      state.allusers.forEach((element) => {
        flag = false;
        state.listfriend.forEach((friend) => {
          if (element.id == friend.userid1 || element.id == friend.userid2) {
            flag = true;
          }
        });
        if (!flag) {
          var item = new Object();
          item.id = element.id;
          item.name = element.login;
          list.push(item);
        }
      });
      return list;
    },
    activelistpurchaseorder(state) {
      return state.listpurchaseorder.filter((object) => {
        return object.orderStateId == null;
      });
    },
    activelistexchangeorder(state) {
      return state.listexchangeorder.filter((object) => {
        return object.orderStateId == null;
      });
    },
    userlistsell(state) {
      return state.listpurchaseorder
        .filter((object) => {
          return object.sellerid == state.user.id;
        })
        .sort((a, b) => {
          if (a.buyerid == null && b.buyerid == null) {
            return -1;
          } else if (a.buyerid != null && b.buyerid == null) {
            return -1;
          } else if (a.buyerid == null && b.buyerid != null) {
            return 1;
          }
        });
    },
    userlistpurchase(state) {
      return state.listpurchaseorder.filter((object) => {
        return object.buyerid == state.user.id;
      });
    },
    userlistexchange(state) {
      return state.listexchangeorder.filter((object) => {
        return object.userid1 == state.user.id;
      });
    },
    userlistexchangeorder(state) {
      return state.listexchangeorder.filter((object) => {
        return object.userid2 == state.user.id;
      });
    },
    collection(state) {
      return state.collection;
    },
    wantbuy(state) {
      return state.wantbuy;
    },
    wantplay(state) {
      return state.wantplay;
    },
    playedgame(state) {
      return state.playedgame;
    },
    wantexchange(state) {
      return state.wantexchange;
    },
    gameById(state) {
      return (gameId) => {
        var item = state.listboardgames.find(
          (game) => game.id.toString() === gameId
        );
        return item;
      };
    },

    /* listGameById(state) {
      return (exchangeOrderId) => {
        var list = [];
        state.listgameexchange.forEach((element) => {
          if (element.exchangeid == exchangeOrderId) {
            var item = new Object();
            item.id = element.id;
            item.photoImage = state.listboardgames.find(
              (game) => game.id == element.gameid
            ).photoImage;
            list.push(item);
          }
        });
        return list;
      };
    },*/
    photoLinkById(state) {
      return (gameId) => {
        var item = state.listboardgames.find((game) => game.id === gameId);
        return item.photoLink;
      };
    },
    photoImageById(state) {
      return (gameId) => {
        var item = state.listboardgames.find((game) => game.id === gameId);
        return "data:image/png;base64," + item.photoImage;
      };
    },
    photoidById(state) {
      return (gameId) => {
        var item = state.listboardgames.find((game) => game.id === gameId);
        return item.photoid;
      };
    },
    purchaseOrderById(state) {
      return (orderId) => {
        var item = state.listpurchaseorder.find(
          (order) => order.id.toString() === orderId
        );
        return item;
      };
    },
    exchangeOrderById(state) {
      return (orderId) => {
        var item = state.listexchangeorder.find(
          (order) => order.id.toString() === orderId
        );
        return item;
      };
    },
    listGameById(state) {
      return (exchangeOrderId) => {
        var list = [];
        state.listgameexchange.forEach((element) => {
          if (element.exchangeid == exchangeOrderId) {
            var item = new Object();
            item.id = element.id;
            item.photoImage = state.listboardgames.find(
              (game) => game.id == element.gameid
            ).photoImage;
            list.push(item);
          }
        });
        return list;
      };
    },
    listExchangeGameById(state) {
      return (exchangeOrderId) => {
        return state.listgameexchange.filter((object) => {
          return object.exchangeid == exchangeOrderId;
        });
      };
    },
    token(state) {
      return state.token;
    },
    flag_login(state) {
      return state.flag_login;
    },
    flag_admin(state) {
      return state.flag_admin;
    },
  },
  mutations: {
    setToken(state, payload) {
      state.token = payload;
    },

    setListBoardgames(state, payload) {
      if (state.listboardgames.length > 0) {
        state.listboardgames.splice(0, state.listboardgames.length);
        state.listselectboargames.splice(0, state.listselectboargames.length);
      }
      payload.forEach((element) => {
        var item = new Object();
        item.id = element.id;
        item.name = element.nameEnglish;
        state.listboardgames.push(element);
        state.listselectboargames.push(item);
      });
    },

    setCollection(state, payload) {
      if (state.collection.length > 0) {
        state.collection.splice(0, state.collection.length);
      }
      payload.forEach((element) => {
        state.collection.push(element);
      });
    },

    setListPurchaseOrder(state, payload) {
      if (state.listpurchaseorder.length > 0) {
        state.listpurchaseorder.splice(0, state.listpurchaseorder.length);
      }
      payload.forEach((element) => {
        state.listpurchaseorder.push(element);
      });
    },

    setListExchangeOrder(state, payload) {
      if (state.listexchangeorder.length > 0) {
        state.listexchangeorder.splice(0, state.listexchangeorder.length);
      }
      payload.forEach((element) => {
        state.listexchangeorder.push(element);
      });
    },

    setListGameExchange(state, payload) {
      if (state.listgameexchange.length > 0) {
        state.listgameexchange.splice(0, state.listgameexchange.length);
      }
      payload.forEach((element) => {
        state.listgameexchange.push(element);
      });
    },

    setWantBuy(state, payload) {
      if (state.wantbuy.length > 0) {
        state.wantbuy.splice(0, state.wantbuy.length);
      }
      payload.forEach((element) => {
        state.wantbuy.push(element);
      });
    },

    setPlayedGame(state, payload) {
      if (state.playedgame.length > 0) {
        state.playedgame.splice(0, state.playedgame.length);
      }
      payload.forEach((element) => {
        state.playedgame.push(element);
      });
    },

    setWantPlay(state, payload) {
      if (state.wantplay.length > 0) {
        state.wantplay.splice(0, state.wantplay.length);
      }
      payload.forEach((element) => {
        state.wantplay.push(element);
      });
    },

    setWantExchange(state, payload) {
      if (state.wantexchange.length > 0) {
        state.wantexchange.splice(0, state.wantexchange.length);
      }
      payload.forEach((element) => {
        state.wantexchange.push(element);
      });
    },

    setUser(state, payload) {
      state.user = payload;
    },

    setFlagLogin(state, payload) {
      state.flag_login = payload;
    },

    setFlagAdmin(state, payload) {
      state.flag_admin = payload;
    },

    setFriend(state, payload) {
      if (state.listfriend.length > 0) {
        state.listfriend.splice(0, state.listfriend.length);
      }
      payload.forEach((element) => {
        state.listfriend.push(element);
      });
    },

    setAllUsers(state, payload) {
      if (state.allusers.length > 0) {
        state.allusers.splice(0, state.allusers.length);
      }
      payload.forEach((element) => {
        state.allusers.push(element);
      });
    },

    setMessageInbox(state, payload) {
      if (state.messageinbox.length > 0) {
        state.messageinbox.splice(0, state.messageinbox.length);
      }
      payload.forEach((element) => {
        state.messageinbox.push(element);
      });
    },

    setMessageOutbox(state, payload) {
      if (state.messageoutbox.length > 0) {
        state.messageoutbox.splice(0, state.messageoutbox.length);
      }
      payload.forEach((element) => {
        state.messageoutbox.push(element);
      });
    },
  },

  actions: {
    setToken({ commit }, payload) {
      commit("setToken", payload);
    },

    setListBoardgames({ commit }, payload) {
      commit("setListBoardgames", payload);
    },

    setListPurchaseOrder({ commit }, payload) {
      commit("setListPurchaseOrder", payload);
    },

    setListExchangeOrder({ commit }, payload) {
      commit("setListExchangeOrder", payload);
    },

    setListGameExchange({ commit }, payload) {
      commit("setListGameExchange", payload);
    },

    setUser({ commit }, payload) {
      commit("setUser", payload);
    },

    setFlagLogin({ commit }, payload) {
      commit("setFlagLogin", payload);
    },

    setFlagAdmin({ commit }, payload) {
      commit("setFlagAdmin", payload);
    },

    setFriend({ commit }, payload) {
      commit("setFriend", payload);
    },

    setAllUsers({ commit }, payload) {
      commit("setAllUsers", payload);
    },

    setMessageInbox({ commit }, payload) {
      commit("setMessageInbox", payload);
    },

    setMessageOutbox({ commit }, payload) {
      commit("setMessageOutbox", payload);
    },

    loadUserDataFromServer({ dispatch }, payload) {
      return Promise.all([
        dispatch("loadCollection", payload),
        dispatch("loadWantBuy", payload),
        dispatch("loadWantPlay", payload),
        dispatch("loadPlayedGame", payload),
        dispatch("loadWantExchange", payload),
        dispatch("loadPurchaseOrder", payload),
        dispatch("loadExchangeOrder", payload),
        dispatch("loadListGameExchange", payload),
        dispatch("loadFriend", payload),
        dispatch("loadAllUsers", payload),
        dispatch("loadMessageInbox", payload),
        dispatch("loadMessageOutbox", payload),
      ]);
    },

    loadCollection({ state, commit }, payload) {
      var config = {
        method: "get",
        url: "/collection/" + payload,
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setCollection", data.data);
        }
      });
    },

    loadWantBuy({ state, commit }, payload) {
      var config = {
        method: "get",
        url: "/wantbuy/" + payload,
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setWantBuy", data.data);
        }
      });
    },

    loadWantPlay({ state, commit }, payload) {
      var config = {
        method: "get",
        url: "/wantplay/" + payload,
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setWantPlay", data.data);
        }
      });
    },

    loadPlayedGame({ state, commit }, payload) {
      var config = {
        method: "get",
        url: "/playedgame/" + payload,
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setPlayedGame", data.data);
        }
      });
    },

    loadWantExchange({ state, commit }, payload) {
      var config = {
        method: "get",
        url: "/exchange/" + payload,
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setWantExchange", data.data);
        }
      });
    },

    loadPurchaseOrder({ state, commit }) {
      var config = {
        method: "get",
        url: "/purchaseorder/allrows",
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setListPurchaseOrder", data.data);
        }
      });
    },

    loadExchangeOrder({ state, commit }) {
      var config = {
        method: "get",
        url: "/exchangeorder/allrows",
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setListExchangeOrder", data.data);
        }
      });
    },

    loadListGameExchange({ state, commit }) {
      var config = {
        method: "get",
        url: "/listgameexchange/allrows",
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setListGameExchange", data.data);
        }
      });
    },

    loadFriend({ state, commit }, payload) {
      var config = {
        method: "get",
        url: "/friend/" + payload,
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setFriend", data.data);
        }
      });
    },

    loadAllUsers({ state, commit }) {
      var config = {
        method: "get",
        url: "/user/allrows",
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setAllUsers", data.data);
        }
      });
    },

    loadAllBoardgames({ state, commit }) {
      var config = {
        method: "get",
        url: "/boardgame/allrows",
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setListBoardgames", data.data);
        }
      });
    },

    loadMessageInbox({ state, commit }, payload) {
      var config = {
        method: "get",
        url: "/message/inbox/" + payload,
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setMessageInbox", data.data);
        }
      });
    },

    loadMessageOutbox({ state, commit }, payload) {
      var config = {
        method: "get",
        url: "/message/sent/" + payload,
        headers: {
          Authorization: `Bearer ${state.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: JSON.stringify({}),
      };
      axios(config).then((data) => {
        if (data.data.length != 0) {
          commit("setMessageOutbox", data.data);
        }
      });
    },
  },
  modules: {},
});
