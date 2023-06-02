
class MainControllerAPI {
    constructor() {
        this.url = "http://192.168.18.188:8080";
    }

    getAllBreed(resp, error) {
        fetch(`${this.url}/breed`).then((responseData) => responseData.json()).then(json => resp(json)).catch(error);
    }

    getSingleBreed(breedName, resp, error) {
        fetch(`${this.url}/breed/${breedName}`).then((responseData) => responseData.json()).then(resp).catch(error);
    }

    likeBreed(breedName, resp, error) {
        fetch(`${this.url}/breed/${breedName}/like`, {
            method: "POST",
            headers: {
                Accept: "application/json",
                'Content-Type': "application/json"
            }
        }).then((responseData) => responseData.json()).then(resp).catch(error);
    }
    dislikeBreed(breedName, resp, error) {
        fetch(`${this.url}/breed/${breedName}/like`, {
            method: "DELETE",
            headers: {
                Accept: "application/json",
                'Content-Type': "application/json"
            }
        }).then((responseData) => responseData.json()).then(resp).catch(error);
    }
    getSingleBreedImg(breedName, resp, error) {
        fetch(`${this.url}/breed/${breedName}/image`).then((responseData) => responseData.json()).then(resp).catch(error);
    }
}

export { MainControllerAPI };