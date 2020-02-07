<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="input-group-3" label="Filmovi:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="form.film"
          :options="options"
          required
        ></b-form-select>
      </b-form-group>



      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
    <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ form }}</pre>
    </b-card>
  </div>
</template>

<script>
import axios from "axios";
// import router from "../router/index.js";
export default {
  name: "AddProjekcija",
  data() {
      return {
        form: {
          email: '',
          name: '',
          film: null,
          checked: []
        },
        options: [
           { value: null, text: 'Please select some item' },
        ],
        show: true
      }
    },
    mounted(){
      var op=[]
    axios
      .get("http://localhost:8081/SF-15-2018-OWP/FilmoviServlet")
      // .then(res => (this.movies = res.data))
      .then(function(response){
        
            for (var i = 0; i < response.data.length; i++) {
         op.push({ value: response.data[i].id, text: response.data[i].naziv })
         console.log(response.data[i].id)
      } 
      })

.catch(err => console.log(err));
 this.options=op;
    },

    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.name = ''
        this.form.film = null
        this.form.checked = []
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
}
</script>