import React from 'react';
import { View, Image, StyleSheet, Text } from 'react-native';
import LikeButton from './LikeButton';
import { MainControllerAPI } from '../dogapi_sdk/models';



const DogCardComponent = ({ breed, breedPhoto, imgWidth = 32, imgHeight = 32, onPress }) => {

    let img = {
        uri: breedPhoto ?? "https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg",
        width: imgWidth,
        height: imgHeight
    }
    const onLikePress = () => {
        new MainControllerAPI().likeBreed(breed.name, () => {
            if (onPress) {
                onPress();
            }
        }, err => console.err(err));
    }
    return (
        <View
            style={{
                flexDirection: 'row',
                alignItems: 'center',
                borderWidth: 3,
                borderColor: 'black',
                width: '80%',
                marginBottom: 8
            }}
        >

            <View style={{
                width: '50%',
                alignItems: 'center',
                flexDirection: 'row'
            }}>
                <Image source={img}></Image>
                <View>
                    <Text style={{ marginLeft: 8 }}>{breed ? breed.name : "NO_BREED"}</Text>
                    <Text style={{ marginLeft: 8 }}>Votes: {breed.votes ?? 0}</Text>
                    <Text style={{ marginLeft: 8 }}>Favorites: {breed.favorited ?? 0}</Text>
                </View>

            </View>
            <View style={{
                justifyContent: 'flex-end',
                alignItems: 'center',
                width: '80%'
            }}>
                <LikeButton onPress={onLikePress} />
            </View>
        </View>
    )
}
export default DogCardComponent;