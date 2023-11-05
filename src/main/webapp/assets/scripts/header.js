

let showBarMenu = document.getElementById('show-bar-menu')
let headerMenuBar = document.getElementById('header-modal-menu')


showBarMenu.addEventListener('click', ()=> {
    headerMenuBar.classList.remove('hidden')
})


let closeBarMenu = document.getElementById('header-close-menu-bar')

closeBarMenu.addEventListener('click', () =>{
    headerMenuBar.classList.add('hidden')
})