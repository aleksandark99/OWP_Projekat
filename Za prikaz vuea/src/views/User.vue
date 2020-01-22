
<template>
   <div>
       <!-- user view
    {{ $route.params.username }} -->
      <b-table striped hover :items="items" :fields="fields"></b-table>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'User',
  props: ['username'],

  data() {
      return {
        // Note 'isActive' is left out and will not appear in the rendered table
        fields: [
          {
            key: 'username',
            sortable: false,
            
          },
          {
            key: 'password',
            sortable: false
          },
          {
            key: 'datumRegistracije',
            sortable: false,
            formatter: 
            value => {
              //  return new Date(value)
             return new Date(value).toLocaleDateString();

            }
            

          }, 
          {
            key: 'uloga',
            sortable: false
          },
               
        ],
        items: [],
        // {"id":1,"naziv":"movie1","reziser":"reziser1","glumci":"glumci 1","zanrovi":"zanrovi 1","trajanje":1,"distributer":"distributer1","zemljaPorekla":"zemlja porekla 1","godina":1,"opis":"opis1"},
        // {"id":2,"naziv":"movie2","reziser":"reziser2","glumci":"glumci 2","zanrovi":"zanrovi 2","trajanje":2,"distributer":"distributer2","zemljaPorekla":"zemlja porekla 2","godina":2,"opis":"opis2"},
        // {"id":3,"naziv":"movie3","reziser":"reziser3","glumci":"glumci 3","zanrovi":"zanrovi 3","trajanje":3,"distributer":"distributer3","zemljaPorekla":"zemlja porekla 3","godina":3,"opis":"opis3"},
        // {"id":4,"naziv":"movie4","reziser":"reziser4","glumci":"glumci 4","zanrovi":"zanrovi 4","trajanje":4,"distributer":"distributer4","zemljaPorekla":"zemlja porekla 4","godina":4,"opis":"opis4"}]
    // methods: {
    //   filmId(value) {
    //     return `${value.naziv } `
    //   },


    // }

}},

mounted (){
axios.get(`http://localhost:8081/SF-15-2018-OWP/KorisnikServlet?username=${this.username}`)
.then(res =>  this.items.push(res.data))
.catch(err => console.log(err))
 }
}
</script>