<style>
    <%--    <%@include file="../../assets/styles/lib/lib.css"%>--%>
    <%@include file="../../assets/styles/my_styling/my_style.css"%>
    <%@include file="../../assets/styles/lib/swipper.css"%>
    <%@include file="../../assets/styles/lib/reveal.css"%>
    <%@include file="../../assets/styles/lib/lib.css"%>


</style>


<script>
    <%@include file="../../assets/scripts/jquery.js"%>
</script>
<script>
    <jsp:include page="../../assets/scripts/lib.js" />
</script>
<script>
    <jsp:include page="../../assets/scripts/scrollReivew.js" />
</script>
<script>
    <jsp:include page="../../assets/scripts/swipper.js" />
</script>

<script>
    window.addEventListener('DOMContentLoaded', (e) => {
        // Scroll to section by link
        var subDomain = document.getElementById("subDomain")
        let home = document.getElementById('home')
        let product = document.getElementById('product')
        let contact = document.getElementById('contact')

        if (subDomain.value === ''){
            home.href = "#sec1"
            product.href = "#slide-product"
            contact.href ="#slide-contact"
        }
    })

    const animateSR = (className, direction = "bottom", duration = 1000, delay = 300) => {
        let cartItem = document.getElementsByClassName(className);
        [...cartItem].forEach((value, index) => {
            let nameSr = "sr-" + (index);
            value.classList.add(nameSr);
            ScrollReveal().reveal("." + nameSr, {
                distance: '100%',
                origin: direction,
                opacity: '0',
                delay: index * delay + delay,
                duration: duration + (index * delay + delay),
                reset: true,
                viewFactor: 0.3,
                viewOffset: { top: 64 },
            });
        })
    }
    // Check Loading and Check Notice
    // UI Loading DOM pushing before check ???
    document.addEventListener('readystatechange', (e)=>{
        if (document.readyState === 'interactive' || document.readyState === 'loading') {
            console.log('loading')
            // still loading, wait for the event
            document.addEventListener('DOMContentLoaded', () => {
                let loading = document.getElementById('loading')
                loading.classList.remove('hidden')
            });
        } else {
            setTimeout(()=>{
                let loading = document.getElementById('loading')
                loading.classList.add('hidden')
            }, (subDomain.value===''?3000:1000))
            setTimeout(()=>{
                let loading = document.getElementById('toast-success')
                loading.classList.add('hidden')
                animateSR('toast-success', 'bottom', 3000, 0)

            }, 4000)
        }
    })

    // Effect HomePage and Loading, Notice
    window.addEventListener("load", () => {
        // Route
        // Loading Ui
        animateSR('loading-component',"bottom", 500, 0)
        // Notice UI
        animateSR('toast-success', 'bottom', 3000, 0)
        // Section Home
        animateSR("items-1");
        animateSR("sec1-title", "top");
        animateSR("product-text", "top");
        animateSR("slide-products"); // if exist, els if no effect

        // Enough files and signal
        document.addEventListener('readystatechange', (e)=> {
            if (document.readyState === 'interactive' || document.readyState === 'loading') {
                console.log('loading')
                // still loading, wait for the event
                document.addEventListener('DOMContentLoaded', () => {
                    let loading = document.getElementById('loading')
                    loading.classList.remove('hidden')
                });
            } else {
                //
                let loading = document.getElementById('loading')
                loading.classList.add('hidden')
                // Slide products: waiting for jsp render.
                animateSR("slide-products");
                // animateSR("slide-product");

            }
        })




        //
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();

                document.querySelector(this.getAttribute('href')).scrollIntoView({
                    behavior: 'smooth',
                    duration: 1000,
                });
            });
        });

        // let loading = document.getElementById('loading')
        // loading.classList.add('hidden')
    })
</script>