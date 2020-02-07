<template>
  <div>
    <div class="container" id="s">
      <div class="row">
        <div class="col-md-6 mx-auto">
          <b-form @submit="onSubmit" @reset="onReset" v-if="show">
            
            <b-form-group id="input-group-1" label="Naziv:" label-for="input-1">
              <b-form-input id="input-1" 
              v-model="form.naziv" 
              required 
              placeholder="Enter naziv">
              </b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Trajanje:" label-for="input-2">
              <b-form-input
                id="input-2"
                v-model="form.trajanje"
                required
                placeholder="Enter Trajanje"
              ></b-form-input>
            </b-form-group>
            <b-form-group id="input-group-3" label="Distributer:" label-for="input-3">
              <b-form-input
                id="input-3"
                v-model="form.distributer"
                required
                placeholder="Enter Distributer"
              ></b-form-input>
            </b-form-group>
            <b-form-group id="input-group-4" label="Zemlja porekla:" label-for="input-4">
              <b-form-input
                id="input-4"
                v-model="form.zemljaPorekla"
                required
                placeholder="Enter Zemlja porekla"
              ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-5" label="Godina proizvodnje:" label-for="input-5">
              <b-form-input
                id="input-5"
                v-model="form.godinaProizvodnje"
                required
                placeholder="Enter Godina proizvodnje"
              ></b-form-input>
            </b-form-group>
            
            

                   <b-form-group id="input-group-6" label="Reziser:" label-for="input-6">
              <b-form-input
                id="input-6"
                v-model="form.reziser"
                required
                placeholder="Enter Reziser "
              ></b-form-input>
            </b-form-group>
             <b-form-group id="input-group-7" label="Glumci:" label-for="input-7">
              <b-form-input
                id="input-7"
                v-model="form.glumci"
                required
                placeholder="Enter Glumci"
              ></b-form-input>
            </b-form-group>
                        <b-form-group id="input-group-8" label="Zanrovi:" label-for="input-8">
              <b-form-input
                id="input-8"
                v-model="form.zanrovi"
                required
                placeholder="Enter Zanrovi"
              ></b-form-input>
            </b-form-group>
                        <b-form-group id="input-group-9" label="Opis:" label-for="input-9">
              <b-form-textarea
                id="input-9"
                type="text"
                v-model="form.opis"
                required
                placeholder="Enter Opis"
                        size="lg"

              ></b-form-textarea>
            </b-form-group>

            <b-button type="submit" variant="primary">Submit</b-button>
            <b-button type="reset" variant="danger">Reset</b-button>
          </b-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import router from "../router/index.js";
export default {
  name: "AddMovie",
  data() {
    return {
      form: {
        
        trajanje: "",
        distributer: "",
        zemljaPorekla: "",
        godinaProizvodnje: "",
        reziser: "",
        glumci: "",
        zanrovi: "",
        opis: "",
        
      },
      show: true
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();


        const params = new URLSearchParams();
        params.append("naziv", this.form.naziv);
        params.append("reziser", this.form.reziser);
        params.append("glumci", this.form.glumci);
        params.append("zanrovi", this.form.zanrovi);
        params.append("trajanje", this.form.trajanje);
        params.append("distributer", this.form.distributer);
        params.append("zemljaPorekla", this.form.zemljaPorekla);
        params.append("godina", this.form.godinaProizvodnje);
        params.append("opis", this.form.opis);  

        axios({
          method: "post",
          url: "http://localhost:8081/SF-15-2018-OWP/AddMovieServlet",
          data: params
        })
          .then(function(response) {
            console.log(response);
            if (response.data.status == "failure") {
              alert("Korisnicko ime je zauzeto");
            }
            if (response.data.status == "success") {
              alert("Uspeno ste se dodali film");
              router.push("/filmovi");
            }
          })
          .catch(function(error) {
            console.log(error);
            alert(error);
          });

    },
    onReset(evt) {
      evt.preventDefault();
      this.form.username = "";
      this.form.password = "";
      this.form.password2 = "";
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>