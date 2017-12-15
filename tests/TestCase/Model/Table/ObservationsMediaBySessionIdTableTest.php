<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\ObservationsMediaBySessionIdTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\ObservationsMediaBySessionIdTable Test Case
 */
class ObservationsMediaBySessionIdTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\ObservationsMediaBySessionIdTable
     */
    public $ObservationsMediaBySessionId;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.observations_media_by_session_id'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('ObservationsMediaBySessionId') ? [] : ['className' => ObservationsMediaBySessionIdTable::class];
        $this->ObservationsMediaBySessionId = TableRegistry::get('ObservationsMediaBySessionId', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->ObservationsMediaBySessionId);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
