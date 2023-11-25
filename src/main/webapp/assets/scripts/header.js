

let showBarMenu = document.getElementById('show-bar-menu')
let headerMenuBar = document.getElementById('header-modal-menu')


showBarMenu.addEventListener('click', ()=> {
    headerMenuBar.classList.remove('hidden')
})


let closeBarMenu = document.getElementById('header-close-menu-bar')

closeBarMenu.addEventListener('click', () =>{
    headerMenuBar.classList.add('hidden')
})


let headerAvatar = document.getElementById('header-avatar')
let settingAvatar = document.getElementById('settings-avatar')
let closeSetting = document.getElementById('close-settings')
headerAvatar.addEventListener('click', (e) => {
    settingAvatar.classList.remove('hidden');
})

closeSetting.addEventListener('click', (e)=>{
    settingAvatar.classList.add('hidden')
})

