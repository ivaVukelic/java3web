const getItems = () => {
    
  fetch(
    '/Grahovica/Items',
    {
        method: 'POST',
        body: '',
        headers : {
            'Content-Type' : 'application/json; charset=utf-8'
        }
    }  
  ).then((response) => {
      response.json().then((response) => {
          let fragment = document.createDocumentFragment();
            for (let i = 0; i < response.length; i++) {
                let temp = response[i];
                
                let item = document.createElement('div');
                item.classList.add('item');
                let itemImg = document.createElement('div');
                itemImg.classList.add('item-img');
                let img256 = document.createElement('img');
                img256.classList.add('img-256');
                img256.src = temp.imgSrc;
                let cartIcon = document.createElement('img');
                cartIcon.classList.add('cart-icon');
                cartIcon.src = temp.iconSrc;
                
                itemImg.appendChild(img256);
                itemImg.appendChild(cartIcon);
                
                item.appendChild(itemImg);
                
                let itemText = document.createElement('div');
                itemText.classList.add('item-text');
                let spanName = document.createElement('span');
                spanName.innerText = temp.name;
                let spanPrice = document.createElement('span');
                spanPrice.innerText = temp.price;

                
                itemText.appendChild(spanName);
                itemText.appendChild(document.createElement('br'));
                itemText.appendChild(spanPrice);
                
                item.appendChild(itemText);
                
                fragment.appendChild(item);
                
            }
            
            document.querySelector('.content').appendChild(fragment);
      });
  });  
    
};