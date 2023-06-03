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
        var dogsVar = {};
        updateDogs()
            .then(dogsList => {
                const allPromise = dogsList.map((dog) => {
                    return new Promise(resolve => {
                        api.getSingleBreedImg(dog.name, resp => {
                            updateCount += 1;
                            resolve({ [dog.name]: resp.imageUrl });
                        })
                    });
                });
                Promise.all(allPromise).then(dogObjList => {
                    let joined = {};
                    joined = dogObjList.reduce((prev, curr) => {
                        return { ...prev, ...curr };
                    }, {});
                    setDogsImgs(joined);
                }).catch(err => {
                    console.error(err);
                })
            }).catch(err => { console.error(err) });
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
            // paddingTop: "30%",
            alignSelf: 'center',
            marginTop: 32,
            marginLeft: 40
        }}>
            {dogs.map((value) => {
                return (
                    <DogCardComponent
                        breed={value}
                        breedPhoto={dogsImgs[value.name]}
                        key={value.id}
                        imgHeight={64}
                        imgWidth={64}
                        onLikePressed={() => { console.log("liking dog" + value.name); updateDogs().catch(err => console.error(err)) }}
                        onDislikePressed={() => { console.log("disliking dog" + value.name); updateDogs().catch(err => console.error(err)) }}
                        onDogDeleted={() => { console.log("dog deleted" + value.name); updateDogs().catch(err => console.error(err)) }}>
                    </DogCardComponent>
                )
            })}
        </ScrollView>
    )
}
export default DogCollectionComponent;