<?php
namespace App\Test\Fixture;

use Cake\TestSuite\Fixture\TestFixture;

/**
 * ObservationsMediaBySessionIdFixture
 *
 */
class ObservationsMediaBySessionIdFixture extends TestFixture
{

    /**
     * Table name
     *
     * @var string
     */
    public $table = 'observations_media_by_session_id';

    /**
     * Fields
     *
     * @var array
     */
    // @codingStandardsIgnoreStart
    public $fields = [
        'Url' => ['type' => 'string', 'length' => 500, 'null' => true, 'default' => null, 'collate' => 'latin1_swedish_ci', 'comment' => '', 'precision' => null, 'fixed' => null],
        'Text' => ['type' => 'string', 'length' => 144, 'null' => true, 'default' => null, 'collate' => 'latin1_swedish_ci', 'comment' => '', 'precision' => null, 'fixed' => null],
        'Sessions_ID' => ['type' => 'integer', 'length' => 11, 'unsigned' => false, 'null' => false, 'default' => '0', 'comment' => '', 'precision' => null, 'autoIncrement' => null],
        '_options' => [
            'engine' => null,
            'collation' => null
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
            'Url' => 'Lorem ipsum dolor sit amet',
            'Text' => 'Lorem ipsum dolor sit amet',
            'Sessions_ID' => 1
        ],
    ];
}
