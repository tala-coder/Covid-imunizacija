
# Specifikacije
https://hackmd.io/@elmedins/SkZFMKg8O <br>
Projekat 1 - Aplikacija za prijavu za vakcinaciju
=================================================

> Prirodno-matematički fakultet\
> Odsjek za matematiku\
> Razvoj mobilnih aplikacija

Logistika
------------------------------------------------------------------------

-   Projekat nosi 30 bodova
-   Rok za predaju projekta je 22. 4. 2021.
-   Prezentacije projekata će se održati 24. 4. 2020.
-   Projekti se rade u parovima koje studenti sami oforme
-   Projekat se ocjenjuje na osnovu kvaliteta samog projekta, dokumentacije i usmene odbrane
-   Ocjene su individualne za svakog studenta na projektu
-   Dokumentacija sadrži opis rada aplikacije sa slikama, opis arhitekture aplikacije, opis funkcionalnosti pojedinačnih klasa, kao i opis opštih koncepata Android frameworka (npr. aktivnost, fragment, lifecycle i sl.)
-   Dokumentacija ne sadrži kod (osim eventualno potpisa klase ili metode)
-   Dokumentacija sadrži minimalno 2500 riječi
-   Plagijarizam će biti ocijenjen sa 0 bodova bez mogućnosti ispravke ovih bodova
-   Dokumentacija se piše u Markdownu (ekstenzija .md)
-   Predaje se dokumentacija sa Android projektom (izvorni kod i resursi, bez generisanih foldera i fajlova)

Opis aplikacije
------------------------------------------------------------------------------------------

Projekta podrazumjeva razvoj Android aplikacije putem koje će se vršiti simulacija prijava za vakcinaciju.\
U nastavku su navedena okvirna uputstva kojih se trebate pridržavati prilikom izrade aplikacije, kao i tehnički zahtjevi koje je potrebno ispuniti kako bi se osvojio maksimalan broj bodova. Detaljne funkcionalnosti nisu navedene kako bi se omogućilo iskazivanje kreativnosti studenata, sposobnosti dizajniranja aplikacije, ali kako bi dobili i raznovrsne aplikacije.

Aplikacija treba sadržavati:

-   uvodni dio
-   provjeru da li korisnik ima prepreku za primanje vakcine (trenutno boluje od virusa Covid-19, trudnoća i sl.)
-   prikupljanje podataka o korisniku (obavezno godine)
-   provjeru o pripadanju prioritetnoj grupi (hronični bolesnici, medicinski radnici, boravak u staračkom domu i sl.)
-   izbor vakcine
-   sažetak prethodnih odgovora
-   prikaz termina i lokacije vakcinacije odnosno
-   prikaz simuliranog broja trenutno registrovanih korisnika (osvježava se pomoću timera)

Aplikacija treba da implementira logiku kojom će se korisnicima prikazivati različiti ekrani u zavisnosti od toga da li ispunjavaju uslov za vakcinaciju ili ne (npr. postojanje prepreka ili strani državljanin).

Također, može se razraditi logika za simulaciju do sada registrovanih korisnika, kao i eventualni statistički prikaz broja izbora svakog proizvođača vakcine, ali ovo nije uslov za osvajanje maksimalnog broja bodova.

Kako bi se ispunili tehnički zahtjevi aplikacija treba koristiti:

-   Fragmente
-   Barem jedan constraint layout
-   View and data binding
-   Navigation komponentu
-   Prosljeđivanje podataka putem Safe Args plug-ina
-   Prevod barem dva fragmenta na engleski jezik
-   Uklanjanje fragmenata sa back-stacka
-   App bar sa bar jednim item-om i up button-om
-   Bočni meni
-   Share button kojim se može poslati predefinisana poruka
-   Timer sa lifecycle observerom
-   Barem jedan fragment sa različitim horizontalnim i vertikalnim layout-om
-   Spašavanje podataka kako bi se sačuvali prilikom zatvaranja aplikacije od samog Android OS-a

Dodatne napomene
---------------------------------------------------------------------------------------------

-   Aplikacija se piše u programskom jeziku Kotlin.
-   Prilikom dizajna preporučeno je držati se standardnih Android vizuelnih rješenja.
