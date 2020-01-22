
<template>
   <!-- <div>
       film view
    {{ $route.params.movieId }}
  </div> -->
  

   <div >
      <b-table  ref="table" striped hover :items="items" :fields="fields"></b-table>

        <!-- <b-button variant="danger" @click="removeMovie">Remove</b-button> -->
        <!-- <b-button variant="success" >Edit</b-button> -->
        <!-- <br>
        <br> -->
        <!-- <Label class="mb-2 mr-sm-2 mb-sm-2">sss</Label>
        <Label class="mb-2 mr-sm-2 mb-sm-2">sss</Label>
        <Label class="mb-2 mr-sm-2 mb-sm-2">sss</Label>
        <Label class="mb-2 mr-sm-2 mb-sm-2">sss</Label>
        <Label class="mb-2 mr-sm-2 mb-sm-2">sss</Label>
        <Label class="mb-2 mr-sm-2 mb-sm-2">sss</Label> -->


        <b-form inline>
    <label class="sr-only" for="inline-form-input-naziv">Naziv</label>
    <b-input
      id="inline-form-input-naziv"
      class="mb-2 mr-sm-2 mb-sm-0"
      placeholder="Novi naziv"
      v-model="naziv"
    ></b-input>

      <label class="sr-only" for="inline-form-input-naziv">Zanrovi</label>
    <b-input
      id="inline-form-input-zanrovi"
      class="mb-2 mr-sm-2 mb-sm-0"
      placeholder="Novi Zanrovi"
      v-model="zanrovi"
    ></b-input>
        <label class="sr-only" for="inline-form-input-trajanje">Trajanje</label>
    <b-input
      id="inline-form-input-trajanje"
      class="mb-2 mr-sm-2 mb-sm-0"
      placeholder="Novo Trajanje"
      v-model="trajanje"
    ></b-input>
        <label class="sr-only" for="inline-form-input-distributer">Distributer</label>
    <b-input
      id="inline-form-input-distributer"
      class="mb-2 mr-sm-2 mb-sm-0"
      placeholder="Novi Distributer"
      v-model="distributer"

    ></b-input>
        <label class="sr-only" for="inline-form-input-zemlja">Zemlja porekla</label>
    <b-input
      id="inline-form-input-zemlja"
      class="mb-2 mr-sm-2 mb-sm-0"
      placeholder="Nova zemlja porekla"
            v-model="zemljaPorekla"

    ></b-input>
        <label class="sr-only" for="inline-form-input-godina">Godina proizvodnje  </label>
    <b-input
      id="inline-form-input-godina"
      class="mb-2 mr-sm-2 mb-sm-0"
      placeholder="Nova godina proizvodnje"
      v-model="godina"
    ></b-input>


    <!-- <b-button variant="primary" @click="EditMovie">Confirm</b-button> -->
  
  </b-form>
  <br>

 <b-button variant="primary" @click="EditMovie">Confirm</b-button> 
  <br>
  <br>
          <b-button variant="danger" @click="removeMovie">Remove</b-button>
      


  </div>
</template>

<script>
import router from '../router/index.js'

import axios from 'axios'
export default {
  name: 'Film',
  props: ['id'],
  data() {
    
      return {
          show:true,
          a:0,

              godina:"",
              trajanje:"",
              naziv:"",
              zanrovi:"",
              distributer:"",
              zemljaPorekla:"",
          
        // Note 'isActive' is left out and will not appear in the rendered table
        fields: [
          
          {
          
            key: 'naziv',
            sortable: false,
             formatter: 'filmId'
            // formatter: (value, key, item) => {
            //   return item.id, item.naziv
            // }
            
          },
          {
            key: 'zanrovi',
            sortable: false
          },
          {
            key: 'trajanje',
            sortable: false,

          }, 
          {
            key: 'distributer',
            sortable: false
          },
                    {
            label:'Zemlja Porekla',
            key: 'zemljaPorekla',
            sortable: false
          },
          {
            label:'Godina Proizvodnje',
            key: 'godina',
            sortable: false
          },
        ],
        items: [],
        // {"id":1,"naziv":"movie1","reziser":"reziser1","glumci":"glumci 1","zanrovi":"zanrovi 1","trajanje":1,"distributer":"distributer1","zemljaPorekla":"zemlja porekla 1","godina":1,"opis":"opis1"},
        // {"id":2,"naziv":"movie2","reziser":"reziser2","glumci":"glumci 2","zanrovi":"zanrovi 2","trajanje":2,"distributer":"distributer2","zemljaPorekla":"zemlja porekla 2","godina":2,"opis":"opis2"},
        // {"id":3,"naziv":"movie3","reziser":"reziser3","glumci":"glumci 3","zanrovi":"zanrovi 3","trajanje":3,"distributer":"distributer3","zemljaPorekla":"zemlja porekla 3","godina":3,"opis":"opis3"},
        // {"id":4,"naziv":"movie4","reziser":"reziser4","glumci":"glumci 4","zanrovi":"zanrovi 4","trajanje":4,"distributer":"distributer4","zemljaPorekla":"zemlja porekla 4","godina":4,"opis":"opis4"}]
    methods: {
      filmId(value) {
        return `${value.naziv } `
      },


    }

}},
methods:
{
  UpdateCurrentMovie(res)
{
        if(res.data.status=="success"){
          this.items[0].naziv=this.naziv
          this.items[0].trajanje=this.trajanje
          this.items[0].distributer=this.distributer
          this.items[0].godina=this.godina
          this.items[0].zanrovi=this.zanrovi
          this.items[0].zemljaPorekla=this.zemljaPorekla
        }else{
          alert(res.data.message)
          this.naziv=""
          this.trajanje=""
          this.distributer=""
          this.godina=""
          this.zanrovi=""
          this.zemljaPorekla=""
          
          
        }

          

},
EditMovie(){
        const params = new URLSearchParams();
        // Ovo bi moglo malo lepse da se uradi al za sada neka ostane ovako
        if(this.naziv == "" ){this.naziv =this.items[0].naziv}
        if(this.zanrovi == "" ){this.zanrovi =this.items[0].zanrovi}
        if(this.trajanje == "" ){this.trajanje =this.items[0].trajanje}
        if(this.distributer == "" ){this.distributer =this.items[0].distributer}
        if(this.zemljaPorekla == "" ){this.zemljaPorekla =this.items[0].zemljaPorekla}
        if(this.godina == "" ){this.godina =this.items[0].godina}

        params.append("naziv", this.naziv);
        params.append("zanrovi", this.zanrovi);
        params.append("trajanje", this.trajanje);
        params.append("distributer", this.distributer);
        params.append("zemljaPorekla", this.zemljaPorekla);
        params.append("godina", this.godina);
        params.append("id", this.items[0].id);
        axios({
          method: "post",
          url: "http://localhost:8081/SF-15-2018-OWP/FilmUpdateServlet",
          data: params
             })
        .then(res =>
        this.UpdateCurrentMovie(res)
        )
        .catch(err=>console.log(err))
        // alert(this.a)
       // this.UpdateCurrentMovie()       
},

  removeMovie(){
    // alert(this.items[0].id)
    const params = new URLSearchParams();
  params.append('id', this.items[0].id);
  axios({
    method: 'post',
    url: 'http://localhost:8081/SF-15-2018-OWP/RemoveFilmServlet',
   data: params
  })
  .then(router.push('/filmovi'))
  .catch(err=> console.log(err))




    
  }
}
,

mounted (){
//console.log(this.id)
  // 'http://172.16.170.175:8081/SF-15-2018-OWP/FilmoviServlet'
  // 'http://localhost:8081/SF-15-2018-OWP/FilmoviServlet'
// axios.get('http://172.16.170.175:8081/SF-15-2018-OWP/FilmServlet',{id : this.$route.params.movieId})
axios.get(`http://localhost:8081/SF-15-2018-OWP/FilmServlet?id=${this.id}`)
 .then(res =>  this.items.push(res.data))
.catch(err => console.log(err))
 }
}
</script>