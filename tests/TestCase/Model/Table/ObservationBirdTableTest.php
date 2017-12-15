<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\ObservationBirdTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\ObservationBirdTable Test Case
 */
class ObservationBirdTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\ObservationBirdTable
     */
    public $ObservationBird;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.observation_bird'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('ObservationBird') ? [] : ['className' => ObservationBirdTable::class];
        $this->ObservationBird = TableRegistry::get('ObservationBird', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->ObservationBird);

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
