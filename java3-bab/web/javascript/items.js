const getItems = (itemType) => {
    
  fetch(
    '/Grahovica/Items',
    {
        method: 'POST',
        body: JSON.stringify({type:itemType}),
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
                cartIcon.src = "/Grahovica/images/icons/cart_64.png";
                cartIcon.addEventListener('click', () => {
                    addToCart(temp);
                });
                
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
            document.querySelector('.content').innerHTML = '';
            document.querySelector('.content').appendChild(fragment);
      });
  });   
    
};

const checkIfItemExists = (id) => {
    
    let ids = document.querySelectorAll('.ih-id');
    
    for (let i = 0; i < ids.length; i++) {
        
        if (ids[i].value === id) {
            return true;
        }
        
    }
    
    return false;
    
};

const addToCart = (item, amountVal = null) => {
    
    if (checkIfItemExists(item.id))
    {
        return;
    }
    
    let cartItems = document.querySelector('.cart-items');
    let fragment = document.createDocumentFragment();
    
    let cartItem = document.createElement('div');
    cartItem.classList.add('cart-item');
    
    let cartImg = document.createElement('div');
    cartImg.classList.add('cart-img');
    
    let image = document.createElement('img');
    image.src = item.imgSrc;
    
    let itemTitle = document.createElement('div');
    itemTitle.classList.add('item-title');
    itemTitle.innerText = item.name;
    
    let iksich = document.createElement('div');
    iksich.classList.add('x-ich');
    iksich.innerText = "X";
    
    iksich.addEventListener('click', () => {
        cartItem.remove();
    });
    
    let itemOptions = document.createElement('div');
    itemOptions.classList.add('item-options');
    
    let ihPrice = document.createElement('input');
    ihPrice.type = 'hidden';
    ihPrice.classList.add('ih-price');
    ihPrice.value = item.price;
    
    let ihId = document.createElement('input');
    ihId.type = 'hidden';
    ihId.classList.add('ih-id');
    ihId.value = item.id;
    
    let amount = document.createElement('input');
    amount.classList.add('item-amount');
    amount.Type = "number";
    amount.value = amountVal === null ? 1 : amountVal;
    
    let itemPrice = document.createElement('div');
    itemPrice.classList.add('item-price');
    itemPrice.innerText = `$${item.price}`;
    
    itemOptions.appendChild(amount);
    itemOptions.appendChild(itemPrice);
    
    cartImg.appendChild(image);
    
    cartItem.appendChild(ihId);
    cartItem.appendChild(ihPrice);
    cartItem.appendChild(cartImg);
    cartItem.appendChild(itemTitle);
    cartItem.appendChild(iksich);
    cartItem.appendChild(itemOptions);
    
    fragment.appendChild(cartItem);
    cartItems.appendChild(fragment);
};

const updateTotal = () => {
    
    let text = document.querySelector('.cart-menu > .item-title');
    let values = document.querySelectorAll('.ih-amount');
    let amounts = document.querySelectorAll('.item-amount');
    let totalValue = 0;
    
    console.log(values);
    console.log(amounts);
    
    for (let i = 0; i < values.length; i++) {
        
        totalValue += Math.floor(amounts[i].value * Number(values[i].value));
        
    }
    
    text.innerText = `Total: $${totalValue}`;
  
};


const saveCart = () => {
    
    let items = [];
    let cartItems = document.querySelectorAll('.cart-item');

    let id;
    let amount;

    for (let i = 0; i < cartItems.length; i++) {
        id = cartItems[i].querySelector('.ih-id').value;
        amount = cartItems[i].querySelector('.item-amount').value;
        items.push({id:id, amount:amount});
    }

    fetch(
    '/Grahovica/CartItems',
    {
        method: 'POST',
        body: JSON.stringify({items:items}),
        headers : {
            'Content-Type' : 'application/json; charset=utf-8'
        }
    }).then((response) =>  response.json().then((response) => console.log(response)));
    
};

const loadCart = () => {
    
    let cartItems = document.querySelector('.cart-items');
    
    fetch(
    '/Grahovica/CartItems',
    {
        method: 'GET',
        headers : {
            'Content-Type' : 'application/json; charset=utf-8'
        }
    }).then((response) =>  response.json().then((response) => {
        
        //for ()
        
    }));
    
};

(() => {
    window.addEventListener('load', () => {
        getItems('All');
        loadCart(); // not finished.
    });
    
    window.addEventListener('beforeunload', () => saveCart());
})();

