# VenadosTest
Prueba Venados Test en Kotlin
Pasos necesarios para construir y ejecutar el proyecto Venados Test Kotlin
1. Crear un activity navigation drawer llamado Home y editar los layouts para adecuar el activity_home_drawer a 3 opciones: Home, Estadísticas y jugadores.
2. Modificar el archivo layout content_home para agregarle un tablayout y un viewpager que mostrara dos tabs fragments donde se visualizaran los 
datos de los resultados de los partidos de la copa MX y ascenso MX respectivamente.
3. Crear la clase viewPagerAdapter.
4. En el activity Home instanciar el viewpager y el tablayout para crear y acceder a los fragments copaMX y AscensoMX.
5. En el activity Home configurar la función OnNavigationItemSelected para acceder a los Fragments Estadisticas y Jugadores respectivamente desde el drawer.
6. Crear las clases Modelos de acuerdo a los datos que se recibirán de la url en formato json para procesarlos y mostrarlos en el recyclerView.
7. Crear las interfaces RetrofitServices las cuáles se encargan de utilizar la libreria retrofit para hacer la petición por metodo get a la url
y obtener los datos de acuerdo a las clases modelos creadas anteriormente.
8. Crear los adaptadores que recibirán listas en forma de objetos de las clases modelos con los datos extraidos de la url desde la función retrofit y que mostraran y actualizaran 
la información en los recyclerViews de los fragments CopaMX, AscensoMX, Estadisticas y Jugadores, respectivamente.
9. Desde cada fragment, se crearan las variables de tipo listas, adaptadores y LayoutManagers, que se encargarán de manipular los datos recibidos 
mediante la funcion getRetrofit implementado en cada fragment, y que los enviarán finalmente a los adaptadores.
10. Los adaptadores reciben los datos en forma de listas y los muestran en pantalla.
