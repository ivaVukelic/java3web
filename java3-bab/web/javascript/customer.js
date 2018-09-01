(() => {
    
    window.addEventListener('load', () => {
        
        fetch(
            '/Grahovica/CartItems',
            {
                method: 'GET',
                headers : {
                    'Content-Type' : 'application/json; charset=utf-8'
                }
            }).then((response) =>  response.json().then((response) => console.log(response)));
        
    });
    
})();