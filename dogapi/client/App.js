import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import DogCardComponent from './components/DogCardComponent'
import DogCollectionComponent from './components/DogCollectionComponent';

export default function App() {
  return (
    <View style={styles.container}>
      <Text style={{
        fontSize: 30
      }}>Dog Rater</Text>
      <DogCollectionComponent />
      {/* <StatusBar style="auto" /> */}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
