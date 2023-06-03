import React, { useRef } from 'react';
import { View, Image, StyleSheet, Text, TouchableWithoutFeedback, ActivityIndicator } from 'react-native';
import LikeButton from './LikeButton';
import { MainControllerAPI } from '../dogapi_sdk/models';



const DogCardComponent = ({ breed, breedPhoto, imgWidth = 32, imgHeight = 32, onLikePressed, onDislikePressed, onDogDeleted }) => {
    const DEFAULT_PHOTO = "https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg"
    let img = {
        uri: breedPhoto ?? null,
        width: imgWidth,
        height: imgHeight
    }
    const timeoutRef = useRef(null);
    const onLikePress = () => {
        new MainControllerAPI().likeBreed(breed.name, () => {
            if (onLikePressed) {
                onLikePressed();
            }
        }, err => console.err(err));
    }
    const onDislikePress = () => {
        new MainControllerAPI().dislikeBreed(breed.name, () => {
            if (onDislikePressed) {
                onDislikePressed();
            }
        }, err => console.err(err));
    }

    const deleteDog = () => {
        console.log("Deleting dog " + breed.name);
        new MainControllerAPI().removeDog(breed.name, () => {
            console.log("Dog deleted");
            onDogDeleted(breed.name)
        })
    }
    const handleOnPressIn = () => {
        console.log("Scheduling dog delete: " + breed.name)
        timeoutRef.current = setTimeout(() => deleteDog(), 2000)
    }
    const handleOnPressOut = () => {
        console.log("Canceling dog delete: " + breed.name)
        clearInterval(timeoutRef.current)
    }
    return (
        <TouchableWithoutFeedback
            onPressIn={handleOnPressIn}
            onPressOut={handleOnPressOut}
        >
            <View
                style={{
                    flexDirection: 'row',
                    alignItems: 'center',
                    borderWidth: 3,
                    borderColor: 'black',
                    width: '100%',
                    marginBottom: 8
                }}

            >


                <View style={{
                    width: '50%',
                    flexDirection: 'column'
                }}>
                    <View style={{
                        width: '50%',
                        alignItems: 'center',
                        flexDirection: 'row'
                    }}>
                        {img.uri ? <Image source={img}></Image> : <ActivityIndicator
                            size={imgWidth}></ActivityIndicator>}
                        <View>
                            <Text style={{ marginLeft: 8 }}>{breed ? breed.name : "NO_BREED"}</Text>
                            <Text style={{ marginLeft: 8 }}>Votes: {breed.votes ?? 0}</Text>
                        </View>

                    </View>
                </View>
                <View style={{
                    width: '50%',
                    alignItems: 'center',
                    justifyContent: 'flex-end',
                    flexDirection: 'column'
                }}>
                    <View style={{
                        flexDirection: 'row',
                        alignItems: 'center',
                        width: '30%'
                    }}>
                        <LikeButton onPress={onLikePress} />
                        <LikeButton dislike={true} onPress={onDislikePress} />
                    </View>
                </View>



            </View>
        </TouchableWithoutFeedback>
    )
}
export default DogCardComponent;