# ConJAVA

Réalisé par :

- Quentin KACZMAREK
- Julien SIBILLE

## Description

Conjugator application in JAVA using a swing interface and a server.

Serveur de conjugaison lancé par défaut sur le port `8000`, pour le changé, modifier le fichier `StartServer.java`.

Lors du lancement du client, vous devez renseigner l'adresse IP du serveur ainsi que le port. Pour une installation par défaut sur une même machine, l'IP est `localhost` et le port `8000`.

## Pré-requis

- installation java ( > 11)
- le dossier lib avec les jars 

## Lancement

### Linux/ MacOS

#### Config

- Donnez les droits d'executions au scripts `run_back.sh`, `run_client.sh` et `stop_back.sh`:

>```bash
>chmod +x run_back.sh
>```

>```bash
>chmod +x run_client.sh
>```

>```bash
>chmod +x stop_back.sh
>```

#### *Lancement*

- Lancez le script `run_back.sh` pour compiler et lancer le serveur: 
>```bash
>./run_back.sh
>```

- Lancez le script `run_client.sh` pour compiler et lancer le client: 
>```bash
>./run_client.sh
>```

#### *Arret*

- Lancez le script `stop_back.sh` pour arrêter ShopRMI et BankRMI:
>```bash
>./stop_back.sh
>```

### Windows


- Lancez le script `run_back.bat` pour compiler et lancer le serveur en double cliquant dessus.

- Lancez le script `run_client.bat` pour compiler et lancer le client  en double cliquant dessus.