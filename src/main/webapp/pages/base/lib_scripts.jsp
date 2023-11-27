
<script>
    <%@include file="../assets/scripts/jquery.js"%>
    <%@include file="../assets/scripts/header.js"%>
</script>
<script>
    <jsp:include page="../assets/scripts/swipper.js" />
</script>
<script>
    <jsp:include page="../assets/scripts/headjs.js" />
</script>
<script>
    <jsp:include page="../assets/scripts/reveal.js" />
</script>
<script>
    <jsp:include page="../assets/scripts/scrollReivew.js" />
</script>

<script>
    const swiper = new Swiper('.swiper', {
        // Optional parameters
        direction: 'horizontal',
        loop: true,
        autoplay: {
            delay: 3000,
        },
        effect: 'fade',
        fadeEffect: {
            crossFade: true
        },

        // If we need pagination
        pagination: {
            el: '.swiper-pagination',
        },

        // Navigation arrows
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },

        // And if we need scrollbar
        scrollbar: {
            el: '.swiper-scrollbar',
        },
    });

</script>
<script>
    Reveal.initialize(
        {
            autoSlide: 5000,
            loop: true,
            view: 'scroll',

            // Force the scrollbar to remain visible
            scrollProgress: true
        }
    );
</script>
<script>
    // Smooth scroll

    ScrollReveal().reveal('.sr-1', {
        distance: '150%',
        origin: 'bottom',
        opacity: '0',
        delay: 200,
        reset: true
    });
    ScrollReveal().reveal('.sr-2', {
        distance: '150%',
        origin: 'bottom',
        opacity: '0',
        delay: 500,
        reset: true
    });
    ScrollReveal().reveal('.sr-3', {
        distance: '150%',
        origin: 'bottom',
        opacity: '0',
        delay: 1000,
        reset: true
    });

    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();

            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });
</script>