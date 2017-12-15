<!-- Map Section -->
<div id="map-section">
    <div class="container">
        <div class="section-title text-center center">
            <h2>Existing Sessions</h2>
            <hr>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div id="map" style="overflow:hidden; /*margin-left:1em; margin-right:1em;*/ padding-bottom:56.25%; position:relative; height:0;">

</div>

<div id="sessionInfo" hidden="true">
    <?php foreach ($sessions as $session){
        echo '<p hidden="true" data-id="'.$session->id.'" data-lat="'.$session->latitude.'" data-lon="'.$session->longitude.'" data-com="'.$session->comment.'"></p>';
    }; ?>
</div>

<!-- Portfolio Section -->
<div id="obs-section">
    <div class="container"> <!-- Container -->
        <div class="section-title text-center center">
            <h2>Related Observations</h2>
            <hr>
            <div class="clearfix"></div>
            <p>Click on a session in the map above to see its different observations below</p>
            <div id="SessionName">
                <br/>
                <h2></h2>
            </div>
        </div>
        <div class="categories">
            <ul class="cat">
                <li>
                    <ol class="type isotopeCategories"></ol>
                </li>
            </ul>
            <div class="clearfix"></div>
        </div>
        <div class="row">
            <div class="portfolio-items"></div>
        </div>
    </div>
</div>

<script src="http://maps.google.com/maps/api/js?key=AIzaSyC5bT8Cecp9X74V4__d7SuesqvaNDayv1w" type="text/javascript"></script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"></script>
<?= $this->Html->script('/js/map.js', array('block' => 'script')) ?>