<template>
  <div>
    <div class="container" id="s">
      <div class="row">
        <div class="col-md-4 mx-auto">
          <b-form @submit="onSubmit" @reset="onReset" v-if="show">
            <b-form-group id="input-group-1" label="Korisnicko ime:" label-for="input-1">
              <b-form-input
                id="input-1"
                v-model="form.username"
                required
                placeholder="Enter username"
              ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Lozinka:" label-for="input-2">
              <b-form-input
                type="password"
                id="input-2"
                v-model="form.password"
                required
                placeholder="Enter password"
              ></b-form-input>
            </b-form-group>
            <b-button type="submit" variant="primary">Submit</b-button>
            <b-button type="reset" variant="danger">Reset</b-button>
          </b-form>
          <!-- <b-card class="mt-3" header="Form Data Result">
            <pre class="m-0">{{ form }}</pre>
          </b-card>-->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import router from "../router/index.js";

// Vue.use(VueRouter)

export default {
  name: "Login",
  props: {},
  data() {
    return {
      form: {
        username: "",
        password: ""
      },
      show: true
    };
  },
  methods: {
    async onSubmit(evt) {
      evt.preventDefault();
      var uname=null;
      var urole = null;
      if (this.form.password != "" && this.form.password2 != "") {
        const params = new URLSearchParams();
        params.append("username", this.form.username);
        params.append("password", this.form.password);
        var uloga = await axios
          .post("http://localhost:8081/SF-15-2018-OWP/LoginServlet", params)

          .then(function(response) {
            if (response.data.status == "failure") {
              alert("Neispravni podaci");
            }
            if (response.data.status == "success") {
              alert("Uspeno ste se ulogovali");
              uname=response.data.userName;
              urole=response.data.role;
            }
            console.log(uname+urole)
            router.push("/");

            return response.data.role; // zaneemari ovo ostalo je od testiranaj i fail pokusaja emitoavanja u app pre stora
          })
          .catch(function(error) {
            console.log(error);
            // alert(error)
            return null;
          });

        console.log(uloga);
        this.$store.commit("changeRole", urole);
        this.$store.commit("changeUsername",uname);
        if(urole=="ADMIN"){
         this.$store.commit("changeSeen", true);

        }

        // this.$store.commit("changeRole", uloga);
      } else {
        alert("Unesite sve podatke");
        this.form.password = "";
        this.form.password2 = "";
      }
    },
    onReset(evt) {
      evt.preventDefault();
      this.form.username = "";
      this.form.password = "";

      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>