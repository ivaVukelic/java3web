
(() => {
    let hiHome;
    let inEmail;
    let inPassword;
    let btnLogin;
    
    window.addEventListener('load', () => {
        hiHome = document.querySelector('#hi-home');
        inEmail = document.querySelector('#in-email');
        inPassword = document.querySelector('#in-password');
        btnLogin = document.querySelector('#btn-login');
        
        hiHome.addEventListener('click', () => {
           window.location.href = '/Grahovica'; 
        });
        
        btnLogin.addEventListener('click', () => {
            fetch(
                '/Grahovica/Authenticator',
                {
                    method: 'POST',
                    body: JSON.stringify({
                        email: inEmail.value,
                        password: inPassword.value
                    }),
                    headers : {
                        'Content-Type':'application/json; charset=utf-8'
                    }
                }
            ).then((req) => {
                return req.json();
            }).then((req) => {
                if (req.isGud === true)
                {
                    window.location.href = `/Grahovica/Signed/${req.path}`;
                }
            });
        });
        
    });
})();

