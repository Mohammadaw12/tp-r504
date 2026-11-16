#!/bin/bash

hello1=0
hello2=0

for i in {1..500}
do
    reponse=$(curl -s http://localhost:83)

    if [[ "$reponse" == *"Hello 1"* ]]; then
        ((hello1++))
    elif [[ "$reponse" == *"Hello 2"* ]]; then
        ((hello2++))
    fi
done

echo "Résultats après 500 requêtes :"
echo "Serveur 1 : $hello1 réponses"
echo "Serveur 2 : $hello2 réponses"

echo "Pourcentage serveur 1 : $((hello1 * 100 / 500)) %"
echo "Pourcentage serveur 2 : $((hello2 * 100 / 500)) %"


