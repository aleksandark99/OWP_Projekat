import Vuex from 'vuex'
import Vue from 'vue'


Vue.use(Vuex);
 
export default new Vuex.Store({
 state: {
   formovie:"",
    user: {
        username:null,
        role: null,
      },
      seen:false,
 },
 getters: {},
 mutations: {
   changeForMovie(state,payload){
      state.formovie=payload;
   },
    changeRole (state, payload) {
        state.user.role = payload
      },
      changeUsername (state, payload) {
        state.user.username = payload
      },

      changeSeen(state,payload){
          state.seen=payload
      }
 },
 actions: {}
});