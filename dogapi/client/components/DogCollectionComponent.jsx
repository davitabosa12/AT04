import React, { useEffect, useState } from 'react';
import { View, Image, StyleSheet, Text, ScrollView } from 'react-native';
import LikeButton from './LikeButton';
import { MainControllerAPI } from '../dogapi_sdk/models';
import DogCardComponent from './DogCardComponent';

const DogCollectionComponent = () => {
    const [dogs, setDogs] = useState([]);
    const [dogsImgs, setDogsImgs] = useState({});
    const [likePressed, setLikePressed] = useState(false);
    const api = new MainControllerAPI();
    useEffect(() => {
        let updateCount = 0
        updateDogs()
            .then(dogsList => {
                dogsList.forEach(dog => {
                    updateCount += 1;
                    console.log(`Getting image ${updateCount} time(s).`);
                    api.getSingleBreedImg(dog.name, resp => {
                        console.log(dogsImgs)
                        setDogsImgs(prev => { return { ...prev, [dog.name]: resp.imageUrl } })
                    })
                });
            });
    }, []);
    const updateDogs = () => {
        return new Promise((resolve, reject) => {
            api.getAllBreed((resp) => {
                setDogs(resp);
                resolve(resp);
            }, error => {
                console.error(error);
                reject(error)
            });
        })

    }
    return (
        <ScrollView style={{
            paddingTop: "30%",
            alignSelf: 'center',
            marginLeft: 40
        }}>
            {dogs.map((value) => {
                return (
                    <DogCardComponent breed={value} breedPhoto={dogsImgs[value.name]} key={value.id} imgHeight={64} imgWidth={64} onPress={() => updateDogs()}></DogCardComponent>
                )
            })}
        </ScrollView>
    )
}
export default DogCollectionComponent;