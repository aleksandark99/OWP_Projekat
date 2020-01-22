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
               required placeholder="Enter password">
               </b-form-input>
               
            </b-form-group>
                        <b-form-group id="input-group-3" label="Potvrdite lozinku:" label-for="input-3">
              <b-form-input
              type="password"
               id="input-3"
               v-model="form.password2" 
               required placeholder="Enter password again">
               </b-form-input>
               <!-- na ovom view-u ce izbaciti verbose neku password glupost izignorisati slobodno nije warning i nije error -->
               
            </b-form-group>
            <b-button type="submit" variant="primary">Submit</b-button>
            <b-button type="reset" variant="danger">Reset</b-button>
          </b-form>
          <!-- <b-card class="mt-3" header="Form Data Result">
            <pre class="m-0">{{ form }}</pre>
          </b-card> -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import router from '../router/index.js'
// Vue.use(VueRouter)

export default {
  name: "AddUser",
  data() {
    return {
      form: {
        username: "",
        password: "",
        password2: "",
      },
      show: true
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      if(this.form.password ===this.form.password2){
      // alert(JSON.stringify(this.form));


      // axios.post(`http://172.16.170.175:8081/SF-15-2018-OWP/RegisterServlet`,
      // {
      //   username:"h",        
      //   password:"h",
      // })

const params = new URLSearchParams();
params.append('username', this.form.username);
params.append('password',this.form.password );
axios({
  method: 'post',
  url: 'http://localhost:8081/SF-15-2018-OWP/RegisterServlet',
  data: params
})
  .then(function (response) {
    console.log(response);
    //     alert(JSON.stringify(response))
    if(response.data.status=="failure"){
      alert("Korisnicko ime je zauzeto")
    }
    if(response.data.status=="success"){
      alert("Uspeno ste se registrovali")
      router.push('/')
      // rutirati na login ... !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    }

  })
  .catch(function (error) {
    console.log(error);
    alert(error)
  })






      

      }
      else{
          alert("Lozinke se ne poklapaju")
          this.form.password = "";
          this.form.password2 = "";
      }
    },
    onReset(evt) {
      evt.preventDefault();
      // Reset our form values
      this.form.username = "";
      this.form.password = "";
      this.form.password2 = "";

      // Trick to reset/clear native browser form validation state
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>