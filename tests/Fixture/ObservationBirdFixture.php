<?php
namespace App\Test\Fixture;

use Cake\TestSuite\Fixture\TestFixture;

/**
 * ObservationBirdFixture
 *
 */
class ObservationBirdFixture extends TestFixture
{

    /**
     * Table name
     *
     * @var string
     */
    public $table = 'observation_bird';

    /**
     * Fields
     *
     * @var array
     */
    // @codingStandardsIgnoreStart
    public $fields = [
        'Observation_ID' => ['type' => 'integer', 'length' => 11, 'unsigned' => false, 'null' => false, 'default' => null, 'comment' => '', 'precision' => null, 'autoIncrement' => null],
        'Bird_ID' => ['type' => 'integer', 'length' => 11, 'unsigned' => false, 'null' => false, 'default' => null, 'comment' => '', 'precision' => null, 'autoIncrement' => null],
        '_indexes' => [
            'Birds_ID' => ['type' => 'index', 'columns' => ['Bird_ID'], 'length' => []],
            'Observations_ID' => ['type' => 'index', 'columns' => ['Observation_ID'], 'length' => []],
        ],
        '_constraints' => [
            'primary' => ['type' => 'primary', 'columns' => ['Observation_ID', 'Bird_ID'], 'length' => []],
            'FK_Bird_Observation' => ['type' => 'foreign', 'columns' => ['Bird_ID'], 'references' => ['bird', 'ID'], 'update' => 'restrict', 'delete' => 'restrict', 'length' => []],
            'FK_Observation_Bird' => ['type' => 'foreign', 'columns' => ['Observation_ID'], 'references' => ['observation', 'ID'], 'update' => 'restrict', 'delete' => 'restrict', 'length' => []],
        ],
        '_options' => [
            'engine' => 'InnoDB',
            'collation' => 'latin1_swedish_ci'
        ],
    ];
    // @codingStandardsIgnoreEnd

    /**
     * Records
     *
     * @var array
     */
    public $records = [
        [
            'Observation_ID' => 1,
            'Bird_ID' => 1
        ],
    ];
}
