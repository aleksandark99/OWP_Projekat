<template>
    <div>
        <b-table responsive :fields="fields" :items="items" :sort-by.sync="sortBy"  
>
      <template v-slot:cell(film.naziv)="data">
        <router-link :to="`/film/${data.item.film.id}`">{{ data.value}}</router-link>
      </template>
          
      
    </b-table>
    </div>
</template>
<script>
// import router from '../router/index.js'

import axios from 'axios'
export default {
    name:'Projekcija',
    props: ['id'],
    data(){
        return{
                  sortBy: 'datum',
      fields: [
        {
          label:'Film',
          key: "film.naziv",
          sortable: true
        },
        {label:'Tip ',
          key: "tipProjekcije.naziv",
          sortable: true
        },
           {
          label:'Sala',
          key: "sala.naizv", // pazi na type bio sam lenj da prepravim bazu
          sortable: true
        },
                {
          key: "cenaKarte",
          sortable: true
        },
        
           {
          key: "datum",
          sortable: true,
          formatter: value => {
            return new Date(value).toLocaleString();
          }
        },
                        {
          key: "Slobodna mesta",
          sortable: true
        },
      ],
      items: []
            
        }
    },
    mounted (){
        console.log(this.id)
//   if(this.$store.state.seen==true){
//     this.show=true;
//   }
axios.get(`http://localhost:8081/SF-15-2018-OWP/ProjekcijaServlet?id=${this.id}`)
.then(res =>  this.items.push(res.data.projekcija))
.catch(err => console.log(err))
 }
    
}
</script>
