class User {
    constructor(number, left, up, right, down) {
        this.number = number
        this.left = left
        this.up = up
        this.right = right
        this.down = down
    }

    power() {
        const a = document.getElementById(`user${this.number}`)
        let horizon = 0;
        let vertical = 0;
        window.addEventListener("keydown", (e) => {

            const code = e.key
            console.log(code)
            if (code == this.right && horizon < 900) {
                horizon += 10
                a.style.left = `${horizon}px`
            }
            if (code == this.down && vertical < 400) {
                vertical += 10
                a.style.top = `${vertical}px`
            }
            if (code == this.left && horizon > 0) {
                horizon += -10
                a.style.left = `${horizon}px`
            }
            if (code == this.up && vertical > 0) {
                vertical += -10
                a.style.top = `${vertical}px`
            }

        }
        )
    }
}

new User(1, "a", "w", "d", "s").power()
new User(2, "ArrowLeft", "ArrowUp", "ArrowRight", "ArrowDown").power()

let num = 0

document.getElementById("create_obj").addEventListener("click", () => {
    let x = Math.floor(Math.random() * 901)
    let y = Math.floor(Math.random() * 401)
    let r = Math.floor(Math.random() * 255)
    let g = Math.floor(Math.random() * 255)
    let b = Math.floor(Math.random() * 255)
    let opa = Math.random() + 0.2
    let scale = Math.floor((Math.random() * 100) + 20)
    let El = document.createElement("div")
    El.id = `npc${num}`
    El.className = `npc`
    El.style.right = `${x}px`
    El.style.bottom = `${y}px`
    El.style.width = `${scale}px`
    El.style.height = `${scale}px`
    El.style.backgroundColor = `rgb(${r},${g},${b},${opa})`
    num += 1
    document.getElementById("op").appendChild(El)
})
document.getElementById("del").addEventListener("click", () => {
    let a = document.getElementsByClassName("npc")
    for (let i = 0; i < a.length; i++) {
        a[i].className = "npc fadeout"

    }
    setTimeout(() => {
        document.getElementById("op").innerHTML = ""
    }, 2000);

})
function bar() {
    const aa = document.getElementById("bar").value
    console.log(aa)
    let b = document.getElementsByClassName("npc")
    for (let i = 0; i < b.length; i++) {
        let rd = Math.floor(Math.random() * 2)

        b[i].style.scale = `${aa * 1.3}%`

    }
}
bar()
document.getElementById("bar").addEventListener("input", bar)


let dd = 1
let asa = document.getElementById("user2")
window.addEventListener("keydown", (e) => {
    console.log(e)
    const space = e.code
    if (space == "Space" && dd == 1) {
        asa.className = "obj space"
        dd = dd * -1
    } else if (space == "Space" && dd == -1) {
        asa.className = "obj"
        dd = dd * -1

    }

})
 