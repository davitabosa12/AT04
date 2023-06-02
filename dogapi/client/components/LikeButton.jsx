import React from 'react';
import { View, Image, StyleSheet, Text, Button, TouchableHighlight } from 'react-native';
import FontAwesome from 'react-native-vector-icons/FontAwesome';

const LikeButton = ({ onPress, dislike = false }) => {
    return (
        <TouchableHighlight onPress={onPress}
            activeOpacity={0.6}
            underlayColor="#DDDDDD">
            <View style={{
                alignItems: 'center',
                backgroundColor: '#DDDDDD',
                padding: 10,
                alignSelf: 'flex-end'
            }}>
                <FontAwesome name={dislike ? 'thumbs-down' : 'thumbs-up'} size={20} />
            </View>
        </TouchableHighlight>
    )
}

export default LikeButton;