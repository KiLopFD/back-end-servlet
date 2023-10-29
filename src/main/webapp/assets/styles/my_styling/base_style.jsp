<style>
    * {
            color: rgb(148 163 184);
        }

        html {
            font-size: 17.6px;
        }

        /* Hover navigation */
        nav ul li:is(:hover) span {
            transition: all 0.7s ease-in-out;
            translate: 0;
            box-shadow: 0 0 0.8rem 0.8rem rgb(226, 63, 63);
            opacity: 1;
        }
        nav ul li:is(:not(:hover)) span {
            transition: all 0.7s ease-in-out;
            translate: -101%;
            opacity: 0;
        }

</style>