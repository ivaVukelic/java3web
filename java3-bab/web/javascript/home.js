
(() => {
    
    let hiFilter;
    let hiLogin;
    let filterMenu;
    let cart;
    let hiCart;
    
    window.addEventListener('load', () => {
        hiFilter = document.querySelector('#hi-filter');
        hiLogin = document.querySelector('#hi-login');
        filterMenu = document.querySelector('.filter-menu');
        cart = document.querySelector('.shopping-cart');
        hiCart = document.querySelector("#hi-cart");
        
        hiFilter.addEventListener('click', () => {
            filterMenu.style.top = 
                    filterMenu.style.top === '100px' ? '-132px' : '100px';
        });
        
        hiLogin.addEventListener('click', () => {
           window.location.href = 'Grahovica/Login'; 
        });
        
        hiCart.addEventListener('click', () =>{
           cart.style.right =
                   cart.style.right === '-900px' ? '0px' : '-900px'; 
        });
        
    });
    
})();
