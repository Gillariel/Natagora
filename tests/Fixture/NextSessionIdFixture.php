<?php
namespace App\Test\Fixture;

use Cake\TestSuite\Fixture\TestFixture;

/**
 * NextSessionIdFixture
 *
 */
class NextSessionIdFixture extends TestFixture
{

    /**
     * Table name
     *
     * @var string
     */
    public $table = 'next_session_id';

    /**
     * Fields
     *
     * @var array
     */
    // @codingStandardsIgnoreStart
    public $fields = [
        'Last_ID' => ['type' => 'biginteger', 'length' => 12, 'unsigned' => false, 'null' => true, 'default' => null, 'comment' => '', 'precision' => null, 'autoIncrement' => null],
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
            'Last_ID' => 1
        ],
    ];
}
