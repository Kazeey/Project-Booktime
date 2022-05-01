export const Constants = {
    port : 3001,
    
    // Database
    dbUrl : "mongodb+srv://m001-student:m001-mongodb-basics@sandbox.iitvj.mongodb.net/Sandbox",
    dbName : "Booktime",
    collections : {
        user : "user",
        book : "book",
        author : "author",
        library : "library"
    },

    // SMTP
    smtp : {
        host : "smtp.gmail.com",
        port : 587,
        username : "booktime.projet@gmail.com",
        password : "Booktime1!",
    },

    // Google
    apiKeyGoogle : "AIzaSyDojgOQt_GHgwTR-bCM--As_WTRERNqz0k",
    apiGoogleUrl : "https://www.googleapis.com/books/v1/volumes?q=",
    categories : [
        "Anthologies",
        "Art",
        "Biographies",
        "Business",
        "Children",
        "Comics",
        "Contemporary",
        "Crime",
        "Engineering",
        "Fantasy",
        "Fiction",
        "History",
        "Horror",
        "Humor",
        "Litterature",
        "Love",
        "Mystery",
        "Manga",
        "Romance",
        "Science",
        "Thriller"
    ],

    // App
    nonAcquis : "N/A",
    noDescription : "Quam ob rem cave Catoni anteponas ne istum quidem ipsum, quem Apollo, ut ais, sapientissimum iudicavit; huius enim facta, illius dicta laudantur. De me autem, ut iam cum utroque vestrum loquar, sic habetote.",
    noDate : new Date("01/05/2022"),
    noImage : "src/images/naThumbnail.jpg",
    
    noUser : "Il n'y a pas d'utilisateur qui corresponde à cet ID",
    noProject : "Il n'y pas de projet qui corresponde à cet ID",
    notId : "Le format de l'identifiant n'est pas correct",

    imagePath : "src/images/"
}