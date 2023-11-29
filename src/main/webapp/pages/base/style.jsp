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
        let about = document.getElementById('about')
        if (subDomain.value === ''){
            home.href = "#sec1"
            product.href = "#slide-product"
            contact.href ="#slide-contact"
            about.href = "#slide-about"
        }
    })

    const animateSR = (className, direction = "bottom", duration = 1000, delay = 300, distance = '100%', reset=true) => {
        let cartItem = document.getElementsByClassName(className);
        [...cartItem].forEach((value, index) => {
            let nameSr = "sr-" + (index);
            value.classList.add(nameSr);
            ScrollReveal().reveal("." + nameSr, {
                distance: distance,
                origin: direction,
                opacity: '0',
                delay: index * delay + delay,
                duration: duration + (index * delay + delay),
                reset: reset,
                viewFactor: 0.3,
                viewOffset: { top: 64 },
            });
        })
    }
    // Check Loading and Check Notice
    // UI Loading DOM pushing before check ???

    // Enough files and signal
    document.addEventListener('readystatechange', (e)=> {

        if (document.readyState === 'interactive' || document.readyState === 'loading') {
            // still loading, wait for the event
            document.addEventListener('DOMContentLoaded', () => {
                let loading = document.getElementById('loading')
                if (loading.className.includes('translate-x-full'))
                    loading.classList.remove('translate-x-full')
            });
        } else {
            //
            setTimeout(()=>{
                let loading = document.getElementById('loading')
                if (!loading.className.includes('translate-x-full'))
                    loading.classList.add('translate-x-full')
            }, (subDomain.value===''?3000:1000))
            setTimeout(()=>{
                let loadingSuccess = document.getElementById('toast-success')
                loadingSuccess.classList.add('hidden')
                animateSR('toast-success', 'bottom', 3000, 0)

            }, 4000)
            setTimeout(()=>{
                let loadingDanger = document.getElementById('toast-danger')
                loadingDanger.classList.add('hidden')
                animateSR('toast-danger', 'bottom', 3000, 0)
            }, 4000)
            // Loading Ui
            // animateSR('loading-component',"bottom", 500, 0)
            // Notice UI
            animateSR('toast-success', 'bottom', 3000, 0)
            animateSR('toast-danger', 'bottom', 3000, 0)

            // Section Home: /
            animateSR("items-1");
            animateSR("items-2");
            animateSR("sec2-title", "top");
            animateSR("sec1-title", "top");
            animateSR("product-text", "top");
            animateSR("slide-products");  // Slide products: waiting for jsp render.
            // /product
            // animateSR("cart-item", "bottom", 1000, 300, "100%", false);
            //
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

            // Header
            if (!settingAvatar.className.includes('translate-x-full')){
                // Show toggle header
                settingAvatar.classList.add('translate-x-full')
                settingAvatar.classList.add('opacity-0')
            }

            // Login, Sign Up:
            let effectLazy = document.getElementById('effect-lazy');
            effectLazy.addEventListener('click', () => {
                let loading = document.getElementById('loading')
                if (loading.className.includes('translate-x-full'))
                    loading.classList.remove('translate-x-full')
            })
        }
    })
</script>