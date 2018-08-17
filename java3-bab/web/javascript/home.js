

(() => {
    
    let hiFilter;
    let hiLogin;
    let filterMenu;
    
    window.addEventListener('load', () => {
        hiFilter = document.querySelector('#hi-filter');
        hiLogin = document.querySelector('#hi-login');
        filterMenu = document.querySelector('.filter-menu');
        
        hiFilter.addEventListener('click', () => {
            filterMenu.style.top = 
                    filterMenu.style.top === '100px' ? '-132px' : '100px';
        });
        
        hiLogin.addEventListener('click', () => {
           window.location.href = 'Grahovica/Login'; 
        });
    });
    
})();
