# INF112 Project – *Astro Adventure*

* Team: *Java Junkies* (Gruppe 1): *Snorre Haland, Kasper Treborg , Bastian Sunde, Elias Aronsen*
* Trello Link: https://trello.com/invite/b/f9N23lGE/ATTIe6bde57c79ea9dd4b28bf7a10b2c4b325186A05D/inf112

## Om spillet
*« Dirk er galaksens beste romutforsker, men etter romskipet hans krasjet må han løpe fra forfølgere hans ved å krysse galaksen!»*

## Hvordan man spiller
* Bruk pil-tastene for å bevege deg rundt!
* Mellomsromstasten brukes for å hoppe mellom planeter!

## Kjøring
* Kompileres med `mvn package`.
* Kjøres med `java -jar target/kurt-mario-1.0-SNAPSHOT-fat.jar`
* Krever Java 15 eller senere

## Kjente feil
*bugs

## Credits
*sprites


## Roller

* Fysikk og hovedkarakter: Snorre
* Terreng: Kasper
* Fiende: Elias
* Git-ansvarlig / kundekontakt: Bastian
* Upgrades og poeng: 




## KONSEPT
* "Vi har lyst til å lage en 2D-platform spill der man hopper rundt fra planet til planet mens man unngår fiender og vanskelig       terreng."


* Spillfigur som kan styres – gå til høyre/venstre, hoppe oppover
* Todimensjonal verden:
    * Plattform – planeter spilleren kan stå eller gå på planeter, spillet skal la deg hoppe fra planet til planet.
    * Planetene skal kunne være forskjellige størrelser.
    * Spilleren beveger seg oppover ved å hoppe, og nedover ved å falle, retningene skal automatisk justeres for hvor du befinner deg rundt planeten.
* Fiender som beveger seg mot karakteren og er skadelige ved berøring
* Spilleren kan samle poeng ved å plukke opp ting.
* Spilleren kan utvide arsenalet ved å plukke opp "upgrades" i formen av f.eks. en grappling hook, jet pack osv...
* Utfordringen blir å holde seg på planetene uten å falle ut i verdensrommet, løpe fra fiender som jager deg fra planet til planet og ungå farlige terreng.

Reffererer til:
* Det blir litt av en blanding mellom Metroid Dread og Super mario oddesey's sin "Moon Kingdom" 2D-section



## Prosjekt metodikk; Kanban
* Vi holder møte på gruppetimene og diskuterer fremgangen i utviklingen.
* Vi bruker discord for kommunikusjon.
* Vi bruker Trello for å holde oversikt over fremgangen.
 
## Oversikt over forventet produkt
* Målet for applikasjonen er et platform spill som tar plass i verdensrommet, spilleren skal komme seg gjennom baner
* ved å hoppe fra planet til planet før "fienden" tar deg igjen. Spilleren har konstant en fiende som følger etter ham
* og målet er å komme seg gjennom banen ved å plukke opp gjenstandene banen krever for progresjon før denne fienden
* tar deg igjen.

* MVP:
  1. Vise et spillebrett
    * Som spiller ønsker jeg å kunne se et spillebrett slik at jeg kan vite hvor jeg er og hvor jeg skal for å fullføre en bane, det vil og hjelpe med å koble hele sammenhengen av spillet.
    
    * Akseptansekriterier:
      * Gitt at jeg viser et spillebrett så kan jeg se banen og danne en forståelse for hvor jeg er og hvor jeg skal.

      * Arbeidsoppgaver:
        * Vi er ferdige med dette MVP-kravet.
  
  2. Vise spiller på spillebrett
     * Som spiller ønsker jeg å kunne se en spiller på spillbrettet (karakteren jeg skal styre) slik at jeg kan vite hva/hvem jeg kontrollerer og danne en forståelse for hvilke egenskaper- 
     * jeg har som spiller.

     * Akseptansekriterier:
       * Gitt at jeg viser en spiller på spillebrettet så kan jeg se karakteren jeg styrer og alltid ha kontroll på hvor spilleren er på spillbrettet,- 
       * samt som jeg kan skille bakgrunn/spillebrett fra min spiller slik at det ikke oppstår misforståelser.

     * Arbeidsoppgaver:
       * Vi er ferdige med dette MVP-kravet.

  3. Flytte spiller(vha taster)
     * Som spiller ønsker jeg å kunne flytte spilleren(vha taster) slik at jeg kan ha kontroll over hvor spilleren skal gå og for å danne en grunnleggende forståelse av hvilke- 
     * muligheter jeg har når det kommer til bevegelse av spilleren.

     * Akseptansekriterier:
       * Gitt at jeg kan flytte spiller vha taster så kan jeg bevege spilleren med tastatur knappene mine og flytte karakteren rundt etter egen vilje.

     * Arbeidsoppgaver:
       * Vi er ferdige med dette MVP-kravet.

  4. Spiller interagerer med terreng
    * Som spiller ønsker jeg at spilleren (min spillbare karakter) interagerer med terreng slik at jeg skal kunne bevege meg rundt på terrenget samt som jeg skal kunne ta i bruk terregnet
    * for å komme frem til mål.
  
    * Akseptansekriterier:
      * Gitt at jeg får spiller til å interagere med terreng så vil spilleren kunne ta i bruk terreng for å kunne manøvere seg gjennom banen og frem til mål.
      * Dette vil også hjelpe med å unngå bugs hvor f.eks. spilleren kan gå gjennom en vegg eller falle gjennom bakken.

    * Arbeidsoppgaver:
      * Vi er ferdige med dette MVP-kravet.

  5. Fungerende gravitasjonsfelt på planetene (spillebrettet)
    * Som spiller ønsker jeg et fungerende gravitasjonsfelt på planetene (spillbrettet) slik at jeg kan manøvere meg fra planet til planet og kunne springe rundt på planeten jeg er på.

    * Akseptansekriterier:
      * Gitt at jeg har fungerende gravitasjonsfelt på planetene (spillebrettet) så vil spilleren og fiender kunne manøvere seg fra planet til planet samt bevege seg rundt på planetene
      * dem allerede er på.

    * Arbeidsoppgaver:
      * Vi er ferdige med dette MVP-kravet.

  6. Vise fiender/monster som også skal interagerer med terreng
  7. generelt fysikk system.
  8. Objekt-fabrikk
  9. Spiller kan dø
  10. Start-skjerm

  * Prioriteringsliste vi vil ha med i første iterajson:
    * Vi vil ha gjort ferdig MVP-krav;
    1. Vise et spillebrett
    2. Vise spiller på spillebrett
    3. Flytte spiller(vha taster)
    4. Spiller interagerer med terreng
    5. Fungerende gravitasjonsfelt på planetene (spillebrettet)
    
## Oppsumering
 Det har gått bra for oss i første fase. Vi har både funnet et konsept vi synest hørrest kult ut å utvikle, og vi har fordelt oppgaver innen gruppen. Til nå i projekt utviklings prossessen så har vi ikke støtt på noen form for problemer, men vi er forbredt i tillfelle vi støter på utfordringer.
 